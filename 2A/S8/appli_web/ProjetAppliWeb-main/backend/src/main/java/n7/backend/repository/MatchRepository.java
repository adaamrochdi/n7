package n7.backend.repository;

import n7.backend.entites.Match;
import n7.backend.entites.enums.StatutMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    // ✅ Ajouter cette méthode personnalisée pour l'étape 2
    List<Match> findByDateGreaterThanEqualOrderByDate(LocalDate from);

    List<Match> findByStatut(StatutMatch statut); // pas indispensable maintenant mais utile plus tard
}
