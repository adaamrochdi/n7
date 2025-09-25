function [F_h, F_p] = HPSS(S)

    N_h=17;
    N_p=17;

    F_h = medfilt2(S, [1, N_h]); 
    F_p = medfilt2(S, [N_p 1]);

   % total = H + P;
   % 
   % harmonicMask = H > (total*0.5);
   % percussiveMask = P > (total*0.5);
   % 
   % F_h = harmonicMask .* S;
   % F_p = percussiveMask .* S;