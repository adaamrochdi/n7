package n7.backend.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import n7.backend.entites.*;
import n7.backend.repository.*;
import org.slf4j.Logger;

@Service
@Transactional
public class GestionJoueursService {
    private static final Logger logger = LoggerFactory.getLogger(GestionJoueursService.class);
    @Autowired
    private JoueurRepository joueurRepo;

    @Autowired
    private StatistiqueRepository statRepo;

    @Autowired
    private ContratRepository contratRepo;

    @Autowired
    private MatchRepository matchRepo;

    @Autowired
    private SessionEntrainementRepository sessionRepo;

    // 1. Ajouter un joueur
    public Joueur ajouterJoueur(Joueur joueur) {
        try {
            logger.info("Ajout du joueur : {}", joueur.getNom());
            return joueurRepo.save(joueur);
        } catch (Exception e) {
            logger.error("Erreur lors de l'ajout du joueur", e);
            throw new RuntimeException("Erreur lors de l'ajout du joueur", e);
        }
    }
    

    public Joueur modifierJoueur(Integer id, Joueur maj) {
        return joueurRepo.findById(id)
                .map(j -> {
                    j.setNom(maj.getNom());
                    j.setPrenom(maj.getPrenom());
                    j.setMaillot(maj.getMaillot());
                    j.setEquipe(maj.getEquipe());
                    j.setDatenaissance(maj.getDatenaissance());
                    j.setArchived(maj.isArchived());  // Mise à jour du statut archived
                    return joueurRepo.save(j);
                })
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + id));
    }
    

    // 3. Archiver un joueur (logique)
    public Joueur archiverJoueur(Integer id) {
        Joueur j = joueurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + id));
        j.setArchived(true);
        return joueurRepo.save(j);
    }
    // 3. desArchiver un joueur (logique)
    public Joueur desarchiverJoueur(Integer id) {
        Joueur j = joueurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + id));
        j.setArchived(false);
        return joueurRepo.save(j);
    }
    // 4. Créer un compte pour le joueur
    public Joueur creerCompte(Integer id, String login, String password) {
        Joueur j = joueurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + id));
        j.setLogin(login);
        j.setPassword(password);
        return joueurRepo.save(j);
    }

    // 5. Gérer contrat professionnel
    public Contrat getContratPro(Integer joueurId) {
        return contratRepo.findByJoueurIdAndType(joueurId, "PRO")
                .orElseThrow(() -> new RuntimeException("Contrat pro non trouvé pour joueur: " + joueurId));
    }

    public Contrat modifierContratPro(Integer contratId, Contrat maj) {
        maj.setId(contratId);
        return contratRepo.save(maj);
    }

    // 6. Ajouter contrat de sponsor
    public Contrat ajouterContratSponsor(Integer joueurId, Contrat contrat) {
        Joueur j = joueurRepo.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        contrat.setJoueur(j);
        return contratRepo.save(contrat);
    }

    // 7. Statistiques
    public Statistique ajouterStatistique(Integer joueurId, Statistique stat) {
        Joueur j = joueurRepo.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        stat.setJoueur(j);
        return statRepo.save(stat);
    }

    public List<Statistique> getStatistiques(Integer joueurId) {
        return statRepo.findByJoueurId(joueurId);
    }
    

    // 8. Affecter match
    public Match affecterMatch(Integer joueurId, Integer matchId) {
        Joueur j = joueurRepo.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        Match m = matchRepo.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match non trouvé: " + matchId));
        j.getMatchs().add(m);
        joueurRepo.save(j);
        return m;
    }

    // 9. Affecter séance
    public SessionEntrainement affecterSession(Integer joueurId, Integer sessionId) {
        Joueur j = joueurRepo.findById(joueurId)
                .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        SessionEntrainement s = sessionRepo.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session non trouvée: " + sessionId));
        j.getSessionEntrainements().add(s);
        joueurRepo.save(j);
        return s;
    }

     // 10bis. Récupérer tous les matchs d'un joueur
    public List<Match> getMatchsJoueur(Integer joueurId) {
        Joueur j = joueurRepo.findById(joueurId)
            .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        return j.getMatchs();
    }

    // 11bis. Récupérer toutes les séances d'entraînement d'un joueur
    public List<SessionEntrainement> getSessionsJoueur(Integer joueurId) {
        Joueur j = joueurRepo.findById(joueurId)
            .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        return j.getSessionEntrainements();
    }

    // 12. Récupérer tous les contrats d'un joueur
    public List<Contrat> getContratsJoueur(Integer joueurId) {
        Joueur j = joueurRepo.findById(joueurId)
            .orElseThrow(() -> new RuntimeException("Joueur non trouvé: " + joueurId));
        return j.getContrats();
    }
    public List<Joueur> getTousLesJoueurs() {
        return joueurRepo.findAll(); // ou filtre `archivé = false` si nécessaire
    }
    public Optional<Joueur> getJoueurParId(Integer id) {
    return joueurRepo.findById(id);
}

    
}
