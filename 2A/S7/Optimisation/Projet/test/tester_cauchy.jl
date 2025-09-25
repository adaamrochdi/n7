using Test

"""
Tester la fonction de pas de Cauchy

# Les cas de test (dans l'ordre)

    - le cas où g est nul
    - le cas où g est non nul, mais sa norme est inférieure à la tolérance absolue
    - le cas où g est non nul et sa norme est supérieure à la tolérance absolue
    - le cas où la matrice H est définie positive
    - le cas où la matrice H a une valeur propre positive et une négative
    - le cas où le pas de Cauchy conduit à un vecteur nul en une itération

"""
function tester_cauchy(cauchy::Function)

    # Tolérance utilisée dans les tests
    tol_test = 1e-3

    @testset "Pas de Cauchy" begin
        # le cas de test 1
        g = [0 ; 0]
        H = [7 0 ; 0 2]
        Δ = 1
        s = cauchy(g, H, Δ)
        @test  s ≈ [0.0 ; 0.0] atol = tol_test

        # le cas de test 2
        g = [0.001 ; 0.002]
        Δ = 1e-5
        s = cauchy(g, H, Δ)
        @test  s ≈ [0.0 ; 0.0] atol = tol_test

        # le cas de test 3
        g = [6 ; 2]
        Δ = 0.5
        s = cauchy(g, H, Δ)
        @test  s ≈ -Δ*g/norm(g) atol = tol_test

        # le cas test 4
        g = [1,2]
        H = [1 0 ; 0 -1]
        Δ = 1.
        s = cauchy(g, H, Δ)
        @test  s ≈ -(Δ/norm(g))*g atol = tol_test

        # le cas de test 5
        g = [2 ; 0]
        H = [4 0 ; 0 -15]
        Δ = 2
        s = cauchy(g, H, Δ)
        @test  s ≈ [-0.5 ; 0.0] atol = tol_test
    end
end

