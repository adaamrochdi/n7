using LinearAlgebra

"""
Approximation d'une solution du problème min f(x), x ∈ Rⁿ, en utilisant l'algorithme de Newton.

# Syntaxe

   x_sol, f_sol, flag, nb_iters, xs = newton(f, gradf, hessf, x0; kwargs...)

# Entrées

   - f       : (Function) la fonction à minimiser
   - gradf   : (Function) le gradient de la fonction f
   - hessf   : (Function) la Hessienne de la fonction f
   - x0      : (Union{Real,Vector{<:Real}}) itéré initial
   - kwargs  : les options sous formes d'arguments "keywords"
      • max_iter : (Integer) le nombre maximal d'itérations (optionnel, par défaut 1000)
      • tol_abs  : (Real) la tolérance absolue (optionnel, par défaut 1e-10)
      • tol_rel  : (Real) la tolérance relative (optionnel, par défaut 1e-8)
      • epsilon  : (Real) le epsilon pour les tests de stagnation (optionnel, par défaut 1)

# Sorties

   - x_sol : (Union{Real,Vector{<:Real}}) une approximation de la solution du problème
   - f_sol : (Real) f(x_sol)
   - flag  : (Integer) indique le critère sur lequel le programme s'est arrêté
      • 0  : convergence
      • 1  : stagnation de xk
      • 2  : stagnation de f
      • 3  : nombre maximal d'itérations dépassé
   - nb_iters : (Integer) le nombre d'itérations faites par le programme
   - xs    : (Vector{Vector{<:Real}}) les itérés

"""
function newton(f::Function, gradf::Function, hessf::Function, x0::Union{Real,Vector{<:Real}}; 
    max_iter::Integer = 1000, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8, 
    epsilon::Real = 1)

   x_sol = x0
   f_sol = f(x_sol)
   flag = 3
   nb_iters = 0
   xs = [x0]

   if norm(gradf(x_sol)) <= max(tol_rel*norm(gradf(x0)), tol_abs)
      flag = 0
      return x_sol, f_sol, flag, nb_iters, xs
   end

   for k in 1:max_iter
      x_prev = x_sol
      f_prev = f_sol

      dk = -hessf(x_prev) \ gradf(x_prev)
      x_sol = x_prev + dk
      f_sol = f(x_sol)
      xs = vcat(xs, [x_sol])

      nb_iters = k

      if norm(gradf(x_sol)) <= max(tol_rel*norm(gradf(x0)), tol_abs)
         flag = 0
         break
      elseif norm(x_sol - x_prev) < epsilon*max(tol_rel*norm(x_prev), tol_abs)
         flag = 1
         break
      elseif abs(f_sol - f_prev) < epsilon*max(tol_rel*norm(f_prev), tol_abs) 
         flag = 2
         break
      end
   end

   return x_sol, f_sol, flag, nb_iters, xs
end
