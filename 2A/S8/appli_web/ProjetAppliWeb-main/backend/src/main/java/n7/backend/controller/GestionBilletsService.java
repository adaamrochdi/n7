package n7.backend.service;

import n7.backend.entites.Billet;
import n7.backend.entites.Match;
import n7.backend.repository.BilletRepository;
import n7.backend.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionBilletsService {

    @Autowired
    private BilletRepository billetRepository;

    @Autowired
    private MatchRepository matchRepository;

    // Récupérer tous les billets
    public List<Billet> getTousLesBillets() {
        return billetRepository.findAll();
    }

    // Récupérer un billet par son id
    public Optional<Billet> getBilletById(int id) {
        return billetRepository.findById(id);
    }

    // Créer un nouveau billet
    public Billet creerBillet(int matchId, String categorie, float prix) {
        Match match = matchRepository.findById(matchId)
            .orElseThrow(() -> new IllegalArgumentException("Match introuvable : " + matchId));
        Billet billet = new Billet();
        billet.setMatch(match);
        billet.setCategorie(categorie);
        billet.setPrix(prix);
        return billetRepository.save(billet);
    }

    // Mettre à jour un billet existant
    public Billet majBillet(int id, int matchId, String categorie, float prix) {
        Billet billet = billetRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Billet introuvable : " + id));
        Match match = matchRepository.findById(matchId)
            .orElseThrow(() -> new IllegalArgumentException("Match introuvable : " + matchId));
        billet.setMatch(match);
        billet.setCategorie(categorie);
        billet.setPrix(prix);
        return billetRepository.save(billet);
    }

    // Supprimer un billet
    public void supprimerBillet(int id) {
        billetRepository.deleteById(id);
    }
}
