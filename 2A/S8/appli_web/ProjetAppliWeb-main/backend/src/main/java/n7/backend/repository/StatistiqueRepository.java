package n7.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import n7.backend.entites.Statistique;

public interface StatistiqueRepository extends JpaRepository<Statistique, Long> {
    List<Statistique> findByJoueurId(Integer joueurId);
}
