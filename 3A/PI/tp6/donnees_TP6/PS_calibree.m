function normales_PS_2D = PS_calibree(images,eclairages)

    M = images * pinv(eclairages)';
    

    rho = sqrt(sum(M.^2, 2));

    normales = M ./ repmat(rho,1,3);

    normales_PS_2D = normales';
    
end