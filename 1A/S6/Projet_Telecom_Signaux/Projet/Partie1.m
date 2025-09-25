%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                   Projet de Télécom/Signal
%                   SCIENCES DU NUMERIQUE 1A
%                          Mai 2024 
%                         ROCHDI Adam
%                      FRYDMAN Alexandre
%           2-Implantation d'une transmission avec
%                transposition de fréquence
%               
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear;
close all;

%% Paramètres de simulation
Fe = 24000; % Fréquence d'échantillonnage en Hz
Rb = 3000; % Débit binaire en bps
Ns = Fe / Rb; % Facteur de suréchantillonnage

M = 4; % Ordre de la modulation QPSK
fp = 2000; % Fréquence porteuse en Hz
rollOff = 0.35; % Roll-off factor du filtre

EbN0_dB = 0:0.1:6; % Gamme du rapport Eb/N0 en dB
retard = Ns*M; % Introduction d'un retard (en fonction de l'ordre de la modulation)


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
%% Transposition sur fréquence porteuse
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

t = (0:length(xe)-1)/Fe; % Vecteur temps
x = real(xe .* exp(1i*2*pi*fp*t));

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Ajout du bruit / Retour en bande de base / Démodulation 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Calcul du TEB
TEB = zeros(1, length(EbN0_dB));
TEB_theorique = qfunc(sqrt(2*10.^(EbN0_dB/10)));

for i = 1:length(EbN0_dB)

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    % Ajout du bruit
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    Px = mean(abs(x).^2); % Calcul de la puissance du signal transmis
    EbN0 = 10^(EbN0_dB(i)/10);
    sigma_n_carre = (Px*Ns)/(2*log2(M)*EbN0); % Calcul de la puissance du bruite à introduire pour travailler au niveau de EbN0 souhaité
    sigma_n = sqrt(sigma_n_carre);
    bruit = sigma_n * randn(1,length(x)); % Génération du bruit
    x_bruite = x + bruit;

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    % Retour en bande de base
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    
    % Partie cos
    partie_cos = x_bruite .* (2*cos(2*pi*fp*t));
    % Filtrage passe-bas
    partie_cos = lowpass(partie_cos, fp, Fe);
    % Partie sin
    partie_sin = x_bruite .* (2*sin(2*pi*fp*t));
    % Filtrage passe-bas
    partie_sin = lowpass(partie_sin, fp, Fe);

    signal = partie_cos - 1i*partie_sin;

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    %% Démodulation en bande de base
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    % Filtre de réception
    hr =  fliplr(h);
    z = filter(hr, 1, signal);

    % Instants optimaux d'échantillonnage (trouvé grace au diagramme de l'oeil)
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

% Tracé du signal transmis sur fréquence porteuse
figure;
plot(t, x);
title('Signal transmis sur fréquence porteuse');
xlabel('Temps (s)');
ylabel('Amplitude');

% Tracé de la densité spectrale de puissance
figure;
pwelch(x,[],[],[],Fe,'centered');
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
scatterplot(zm);
title("Constellation en sortie de l'échantillonneur");

% Tracé du diagramme de l'oeil
z = reshape(angle(z),2*Ns,[]);
figure;
plot(z(:,2:end));
xlabel("indice");
ylabel("z (v)");
title("Diagramme de l'oeil");
grid on;

% Comparaison du symbole et du signal échantillonné
figure;
plot(angle(zm),'r');
hold on;
plot(angle(symboles),'b');
legend("signal échantillonné","symbole");
title("Comparaison symbole signal_echant");
grid on;