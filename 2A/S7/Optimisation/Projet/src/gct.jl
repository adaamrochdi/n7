using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s, sous la contrainte ‖s‖ ≤ Δₖ

# Syntaxe

    s = gct(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Matrix{<:Real}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • max_iter : le nombre maximal d'iterations (optionnel, par défaut 100)
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel  : la tolérence relative (optionnel, par défaut 1e-8)

# Sorties

    - s : (Vector{<:Real}) une approximation de la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = gct(g, H, Δ)

"""
function gct(g::Vector{<:Real}, H::Matrix{<:Real}, Δ::Real; 
    max_iter::Integer = 100, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8)

    n = length(g)

    s = zeros(length(g))
    g0 = g
    j = 0
    p = -g

    function solve(sj, pj)
        a = transpose(pj) * pj
        b = 2*transpose(sj) * pj
        c = transpose(sj) * sj - Δ^2
        r1 = (-b + sqrt(b^2 - 4*a*c)) / (2*a)
        r2 = (-b - sqrt(b^2 - 4*a*c)) / (2*a)

        return r1, r2
    end

    function min(r1, r2, g, s, p, H)
        if transpose(g) * (s + r1 * p) + 0.5 * transpose(s + r1 * p) * H * (s + r1 * p) <= transpose(g) * (s + r2 * p) + 0.5 * transpose(s + r2 * p) * H * (s + r2 * p)
            return r1
        else 
            return r2
        end
    end

    while j < max_iter && norm(g) > max(norm(g0)*tol_rel, tol_abs)
        k = transpose(p) * H * p
        if k <= 0
            r1, r2 = solve(s, p)
            gamma = min(r1, r2, g, s, p, H)
            return s + gamma * p
        end
        alpha = transpose(g) * g / k
        if norm(s + alpha * p) >= Δ
            #  la racine positive de ∥sj + σpj ∥ = ∆
            r1, r2 = solve(s, p)
            r = max(r1, r2)
            return s + r * p
        end
        s = s + alpha * p
        g_prev = g
        g = g + alpha * H * p
        beta = (transpose(g) * g) / (transpose(g_prev) * g_prev)
        p = -g + beta * p
        j += 1
    end

   return s
    
end
