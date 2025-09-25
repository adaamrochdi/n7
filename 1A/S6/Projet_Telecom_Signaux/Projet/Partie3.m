%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                   Projet de Télécom/Signal
%                   SCIENCES DU NUMERIQUE 1A
%                          Mai 2024 
%                         ROCHDI Adam
%                      FRYDMAN Alexandre
%
%           4-Comparaison du modulateur DVS-S avec
%                   un modulateur 4-ASK
%
%               
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
clear all;
close all;

%% Paramètres de simulation
Fe = 6000; % Fréquence d'échantillonnage en Hz
Rb = 3000; % Débit binaire en bps
Ns = Fe / Rb; % Facteur de suréchantillonnage

M = 4; % Ordre de la modulation 4-ASK
fp = 2000; % Fréquence porteuse en Hz
rollOff = 0.35; % Roll-off factor du filtre

EbN0_dB = 0:6; % Gamme du rapport Eb/N0 en dB
retard = Ns * M; % Introduction d'un retard (en fonction de l'ordre de la modulation)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Génération aléatoire de l'information binaire
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

nBits = 6000; % Nombre de bits (multiple de 4 et 6)
bits = randi([0 1], 1, nBits);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Modulation en bande de base
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Mapping
symboles = ASK4(bits);
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
TEB_theorique = (3/4) * qfunc(sqrt((4/5) * 10.^(EbN0_dB/10)));

for i = 1:length(EbN0_dB)

    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    % Ajout du bruit
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    Px = mean(abs(xe).^2); % Calcul de la puissance du signal transmis
    EbN0 = 10^(EbN0_dB(i)/10);
    sigma_n_carre = (Px * Ns) / (2 * log2(M) * EbN0); % Calcul de la puissance du bruit
    sigma_n = sqrt(sigma_n_carre);
    bruit = sigma_n * randn(1, length(xe)); % Génération du bruit
    xe_bruite = xe + bruit;

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
    bitsDemap = ASK4demap(zm); % Demapping
    erreur = abs(bits - bitsDemap);
    TEB(i) = mean(erreur);

end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% Figures
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

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
z_bis = reshape(z, 3*Ns, []);
figure;
plot(z_bis(:,2:end));
xlabel("Indice");
ylabel("z (v)");
title("Diagramme de l'oeil");
grid on;

% Comparaison du symbole et du signal échantillonné
figure;
plot(zm, 'r');
hold on;
plot(symboles, 'b');
legend("Signal échantillonné", "Symbole");
title("Comparaison symbole signal échantillonné");
grid on;
