package n7.backend.service;

import jakarta.persistence.EntityNotFoundException;
import n7.backend.entites.FeuilleDeMatch;
import n7.backend.entites.Match;
import n7.backend.entites.enums.StatutMatch;
import n7.backend.repository.FeuilleDeMatchRepository;
import n7.backend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class GestionMatchsService {

    @Autowired
    private MatchRepository matchRepo;

    @Autowired
    private FeuilleDeMatchRepository feuilleRepo;

    public List<Match> getTous() {
        return matchRepo.findAll();
    }

    public List<Match> getProchains() {
        return matchRepo.findByDateGreaterThanEqualOrderByDate(LocalDate.now());
    }

    public Match planifier(Match m) {
        return matchRepo.save(m);
    }

    public Optional<Match> getById(int id) {
        return matchRepo.findById(id);
    }


    public Match majMatch(int id, Match update) {
        Match m = matchRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match " + id + " introuvable"));

        m.setDate(update.getDate());
        m.setHeureDebut(update.getHeureDebut());
        m.setHeureFin(update.getHeureFin());
        m.setTerrain(update.getTerrain());
        m.setAdversaire(update.getAdversaire());
        m.setEquipe(update.getEquipe());

        return m;
    }

    public void supprimer(int id) {
        Match m = matchRepo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Match " + id + " introuvable"));
    
        // Supprimer la feuille de match s’il y en a une
        if (m.getFeuilleDeMatch() != null) {
            feuilleRepo.delete(m.getFeuilleDeMatch());
        }
    
        // TODO : si tu as un billetRepo, tu peux aussi supprimer les billets ici
        // if (m.getBillets() != null && !m.getBillets().isEmpty()) {
        //     billetRepo.deleteAll(m.getBillets());
        // }
    
        matchRepo.delete(m);
    }
    

    public Match saisirResultat(int id, int scoreEq, int scoreAdv) {
        Match m = matchRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match " + id + " introuvable"));

        m.setScoreEquipe(scoreEq);
        m.setScoreAdverse(scoreAdv);
        m.setStatut(StatutMatch.PLAYED);

        return m;
    }

    public FeuilleDeMatch genererFeuille(int matchId) {
        Match m = matchRepo.findById(matchId)
                .orElseThrow(() -> new EntityNotFoundException("Match " + matchId + " introuvable"));

        FeuilleDeMatch f = new FeuilleDeMatch();
        f.setMatch(m);

        return feuilleRepo.save(f);
    }

    public FeuilleDeMatch getFeuille(int id) {
        return feuilleRepo.findById(id).orElseThrow();
    }
}
