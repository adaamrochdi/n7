%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                   Projet de Télécom/Signal
%                   SCIENCES DU NUMERIQUE 1A
%                          Mai 2024 
%                         ROCHDI Adam
%                      FRYDMAN Alexandre
%     3-Implantation de la chaine passe-bas équivalente à la chaine de
%            transmission sur porteuse précédente
%               
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear;
close all;

%% Paramètres de simulation
Fe = 6000; % Fréquence d'échantillonnage en Hz
Rb = 3000; % Débit binaire en bps
Ns = Fe / Rb; % Facteur de suréchantillonnage

M = 4; % Ordre de la modulation QPSK
fp = 2000; % Fréquence porteuse en Hz
rollOff = 0.35; % Roll-off factor du filtre

EbN0_dB = 0:0.1:6; % Gamme du rapport Eb/N0 en dB
retard = Ns * M; % Introduction d'un retard (en fonction de l'ordre de la modulation)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Génération aléatoire de l'information binaire
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

nBits = 10000; % Nombre de bits
bits = randi([0 1], 1, nBits);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Modulation en bande de base
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Mapping
symboles = QPSK(bits);
Dirac = kron(symboles, [1 zeros(1, Ns-1)]);

% Filtre de mise en forme
h = rcosdesign(rollOff, M, Ns, 'sqrt');

% Filtrage
xe = filter(h, 1, [Dirac zeros(1, retard)]);
xe = xe(retard+1 : end);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Canal complexe 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Calcul du TEB
TEB = zeros(1, length(EbN0_dB));
TEB_theorique = qfunc(sqrt(2*10.^(EbN0_dB/10)));

for i = 1:length(EbN0_dB)

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    % Ajout du bruit
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    Px = mean(abs(xe).^2); % Calcul de la puissance du signal transmis
    EbN0 = 10^(EbN0_dB(i)/10);
    sigma_n_carre = (Px * Ns) / (2 * log2(M) * EbN0); % Calcul de la puissance du bruit
    sigma_n = sqrt(sigma_n_carre);
    bruit_I = sigma_n * randn(1, length(xe)); % Génération du bruit en phase
    bruit_Q = sigma_n * randn(1, length(xe)); % Génération du bruit en quadrature
    bruit_complexe = bruit_I + 1j * bruit_Q;
    xe_bruite = xe + bruit_complexe;

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %% Démodulation en bande de base
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    % Filtre de réception
    hr = fliplr(h);
    z = filter(hr, 1, xe_bruite);

    % Instants optimaux d'échantillonnage (trouvés grâce au diagramme de l'oeil)
    n0 = 1;

    % Démodulation personnalisée et calcul du TEB
    zm = z(n0:Ns:end); % z(n0 + mNs) m€N
    bitsDemap = QPSKdemap(zm); % Demapping
    erreur = abs(bits - bitsDemap);
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

% Tracé de la densité spectrale de puissance de l'enveloppe complexe associée au signal transmis
figure;
pwelch(xe,[],[],[],Fe,'centered');
title('Densité spectrale de puissance du signal transmis');

% Tracé des constellations en sortie du mapping
scatterplot(symboles);
title('Constellation en sortie du mapping');

% Tracé des constellations en sortie de l'échantillonneur
scatterplot(zm);
title("Constellation en sortie de l'échantillonneur");

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

% Tracé du diagramme de l'oeil
z_bis = reshape(angle(z),2*Ns,[]);
figure;
plot(z_bis(:,2:end));
xlabel("Indice");
ylabel("z (v)");
title("Diagramme de l'oeil");
grid on;

% Comparaison du symbole et du signal échantillonné
figure;
plot(angle(zm), 'r');
hold on;
plot(angle(symboles), 'b');
legend("Signal échantillonné", "Symbole");
title("Comparaison symbole signal échantillonné");
grid on;
