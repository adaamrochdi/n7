%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                   Projet de Télécom/Signal
%                   SCIENCES DU NUMERIQUE 1A
%                          Mai 2024 
%                        ROCHDI Adam
%                     FRYDMAN Alexandre
%           5-Comparaison du modulateur DVS-S avec un des
%               modulateurs proposés par le DVB-S2
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

clear all;
close all;

%% Paramètres de simulation
Fe = 6000; % Fréquence d'échantillonnage en Hz
Rb = 3000; % Débit binaire en bps
Ns = Fe / Rb; % Facteur de suréchantillonnage

M = 8; % Ordre de la modulation 8-PSK
fp = 2000; % Fréquence porteuse en Hz
rollOff = 0.2; % Roll-off factor du filtre

EbN0_dB = 0:0.1:6; % Gamme du rapport Eb/N0 en dB
retard = Ns * M; % Introduction d'un retard

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Génération aléatoire de l'information binaire
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

nBits = 9000; % Nombre de bits (multiple de 3)
bits = randi([0 1], 1, nBits);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Modulation en bande de base
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Mapping
symboles = pskmod(reshape(bits, 3, nBits/3), M, 'InputType', 'bit');
Dirac = kron(symboles, [1 zeros(1, Ns-1)]);

% Filtre de mise en forme
h = rcosdesign(rollOff, M, Ns, 'sqrt');

% Filtrage
xe = filter(h, 1, [Dirac zeros(1, retard)]);
xe = xe(retard+1 : end);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Canal complexe 
%% Passe-bas équivalent
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Calcul du TEB
TEB = zeros(1, length(EbN0_dB));
TEB_theorique = (2/3) * qfunc(sqrt(2 * 3 * (10.^(EbN0_dB/10)) * sin(pi/8)^2));

for i = 1:length(EbN0_dB)

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    % Ajout du bruit
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    
    Pxe = mean(abs(xe).^2);
    EbN0 = 10^(EbN0_dB(i)/10);
    sigma_n_carre = (Pxe * Ns) / (2 * log2(M) * EbN0);
    sigma_n = sqrt(sigma_n_carre);
    nI = sigma_n * randn(1, length(xe));
    nQ = sigma_n * randn(1, length(xe));
    bruit = nI + 1j * nQ;
    xe_bruite = xe + bruit;

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %% Démodulation en bande de base
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    % Filtre de réception
    hr = fliplr(h);
    z = filter(hr, 1, xe_bruite);

    % Instants optimaux d'échantillonnage
    n0 = 1;

    % Démodulation personnalisée et calcul du TEB
    signal_echant = z(n0:Ns:end); % z(n0 + mNs) m€N
    bitsRecuperes = pskdemod(signal_echant, M, 'OutputType', 'bit');
    bitsRecuperes = bitsRecuperes(:)'; % Assurez-vous que bitsRecuperes est un vecteur ligne

    % Ajuster la taille des vecteurs pour la comparaison
    if length(bitsRecuperes) > length(bits)
        bitsRecuperes = bitsRecuperes(1:length(bits));
    elseif length(bitsRecuperes) < length(bits)
        bits = bits(1:length(bitsRecuperes));
    end

    % Calcul des erreurs
    erreur = abs(bits - bitsRecuperes);
    TEB(i) = mean(erreur);
    
end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Figures
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

t = (0:length(xe)-1)/Fe; % Vecteur temps

% Tracé des voies en phase et en quadrature
figure;
subplot(2,1,1);
plot(t, real(xe));
title('Voie en phase');
xlabel('Temps (s)');
ylabel('Amplitude');

subplot(2,1,2);
plot(t, imag(xe));
title('Voie en quadrature');
xlabel('Temps (s)');
ylabel('Amplitude');

% Tracé de la densité spectrale de puissance
figure;
pwelch(xe, [], [], [], Fe, 'centered');
title('Densité spectrale de puissance');

% Tracé du TEB
figure;
semilogy(EbN0_dB, TEB, 'b*-');
hold on;
semilogy(EbN0_dB, TEB_theorique, 'r--');
legend('TEB simulé', 'TEB théorique');
title('Taux d''erreur binaire');
xlabel('E_b/N_0 (dB)');
ylabel('TEB');
grid on;

% Tracé des constellations en sortie du mapping
scatterplot(symboles);
title('Constellation en sortie du mapping');

% Tracé des constellations en sortie de l'échantillonneur
scatterplot(signal_echant);
title("Constellation en sortie de l'échantillonneur");

% Tracé du diagramme de l'oeil
z_bis = reshape(angle(z), 2*Ns, []);
figure;
plot(z_bis(:, 2:end));
xlabel("indice");
ylabel("z (v)");
title("Diagramme de l'oeil");
grid on;

% Comparaison du symbole et du signal échantillonné
figure;
plot(angle(signal_echant), 'r');
hold on;
plot(angle(symboles), 'b');
legend("signal échantillonné", "symbole");
title("Comparaison symbole signal échantillonné");
grid on;
