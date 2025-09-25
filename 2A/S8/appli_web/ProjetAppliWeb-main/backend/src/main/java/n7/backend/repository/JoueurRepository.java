package n7.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import n7.backend.entites.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
    
}
