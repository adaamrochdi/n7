package n7.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import n7.backend.entites.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {
    Optional<Contrat> findByJoueurIdAndType(Integer joueurId, String type);
}