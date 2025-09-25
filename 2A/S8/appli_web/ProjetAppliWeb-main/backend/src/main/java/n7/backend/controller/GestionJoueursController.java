package n7.backend.controller;

import n7.backend.entites.*;
import n7.backend.service.GestionJoueursService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(
    origins = { "http://localhost:5173", "http://127.0.0.1:5173" },
    allowedHeaders = "*",
    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS },
    allowCredentials = "true"
)
@RestController
@RequestMapping("/api/joueurs")
public class GestionJoueursController {

    @Autowired
    private GestionJoueursService joueurService;
    // 0. Récupérer tous les joueurs
    @GetMapping
    public List<Map<String, Object>> getAllJoueurs() {
        List<Joueur> joueurs = joueurService.getTousLesJoueurs();
        return joueurs.stream().map(j -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", j.getId());
            map.put("nom", j.getNom());
            map.put("prenom", j.getPrenom());
            map.put("maillot", j.getMaillot());
            map.put("equipe", j.getEquipe());
            map.put("datenaissance", j.getDatenaissance());
            map.put("archived", j.isArchived());
            // Add other fields as needed but exclude collections
            return map;
        }).collect(Collectors.toList());
    }
    

    // 1. Ajouter un joueur
    @PostMapping(consumes = {"application/json"})
    public Joueur ajouterJoueur(@RequestBody Map<String, Object> joueurMap) {
        Joueur joueur = new Joueur();
        joueur.setNom((String) joueurMap.get("nom"));
        joueur.setPrenom((String) joueurMap.get("prenom"));
        joueur.setMaillot((Integer) joueurMap.get("maillot"));
        joueur.setEquipe((String) joueurMap.get("equipe"));
        
        // Convertir la date de String à LocalDate
        String dateStr = (String) joueurMap.get("datenaissance");
        if (dateStr != null && !dateStr.isEmpty()) {
            joueur.setDatenaissance(LocalDate.parse(dateStr));
        }
        
        return joueurService.ajouterJoueur(joueur);
    }

    // 2. Modifier un joueur
    @PutMapping(value = "/{id}", consumes = {"application/json"})
    public Joueur modifierJoueur(@PathVariable Integer id, @RequestBody Map<String, Object> joueurMap) {
        Joueur joueur = new Joueur();
        joueur.setNom((String) joueurMap.get("nom"));
        joueur.setPrenom((String) joueurMap.get("prenom"));
        joueur.setMaillot((Integer) joueurMap.get("maillot"));
        joueur.setEquipe((String) joueurMap.get("equipe"));

        String dateStr = (String) joueurMap.get("datenaissance");
        if (dateStr != null && !dateStr.isEmpty()) {
            joueur.setDatenaissance(LocalDate.parse(dateStr));
        }

        return joueurService.modifierJoueur(id, joueur);
    }

    

    // 3. Archiver un joueur
    @PutMapping("/{id}/archiver")
    public Joueur archiverJoueur(@PathVariable Integer id) {
        return joueurService.archiverJoueur(id);
    }
    // 3. Archiver un joueur
    @PutMapping("/{id}/desarchiver")
    public Joueur desarchiverJoueur(@PathVariable Integer id) {
        return joueurService.desarchiverJoueur(id);
    }

    // 4. Créer un compte
    @PutMapping("/{id}/compte")
    public Joueur creerCompte(@PathVariable Integer id,
                              @RequestParam String login,
                              @RequestParam String password) {
        return joueurService.creerCompte(id, login, password);
    }

    // 5. Récupérer contrat pro
    @GetMapping("/{id}/contrat-pro")
    public Contrat getContratPro(@PathVariable Integer id) {
        return joueurService.getContratPro(id);
    }

    // 6. Modifier contrat pro
    @PutMapping("/contrat/{id}")
    public Contrat modifierContrat(@PathVariable Integer id, @RequestBody Contrat contrat) {
        return joueurService.modifierContratPro(id, contrat);
    }

    // 7. Ajouter contrat sponsor
    @PostMapping("/{id}/contrat-sponsor")
    public Contrat ajouterContratSponsor(@PathVariable Integer id, @RequestBody Contrat contrat) {
        return joueurService.ajouterContratSponsor(id, contrat);
    }

    // 8. Ajouter statistique
    @PostMapping(value = "/{id}/statistiques", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Statistique ajouterStatistique(@PathVariable Integer id, @RequestBody Statistique stat) {
        return joueurService.ajouterStatistique(id, stat);
    }

    // 9. Récupérer les statistiques
    @GetMapping("/{id}/statistiques")
    public List<Statistique> getStatistiques(@PathVariable Integer id) {
        return joueurService.getStatistiques(id);
    }

    // 10. Affecter à un match
    @PutMapping("/{id}/match/{matchId}")
    public Match affecterMatch(@PathVariable Integer id, @PathVariable Integer matchId) {
        return joueurService.affecterMatch(id, matchId);
    }

    // 11. Affecter à une session d'entraînement
    @PutMapping("/{id}/session/{sessionId}")
    public SessionEntrainement affecterSession(@PathVariable Integer id, @PathVariable Integer sessionId) {
        return joueurService.affecterSession(id, sessionId);
    }

    // 12. Récupérer tous les matchs d'un joueur
    @GetMapping("/{id}/matchs")
    public List<Match> getMatchsJoueur(@PathVariable("id") Integer id) {
        return joueurService.getMatchsJoueur(id);
    }

    // 13. Récupérer toutes les séances d'entraînement d'un joueur
    @GetMapping("/{id}/sessions")
    public List<SessionEntrainement> getSessionsJoueur(@PathVariable("id") Integer id) {
        return joueurService.getSessionsJoueur(id);
    }

    // 14. Récupérer tous les contrats d'un joueur
    @GetMapping("/{id}/contrats")
    public List<Contrat> getContratsJoueur(@PathVariable("id") Integer id) {
        return joueurService.getContratsJoueur(id);
    }

}
