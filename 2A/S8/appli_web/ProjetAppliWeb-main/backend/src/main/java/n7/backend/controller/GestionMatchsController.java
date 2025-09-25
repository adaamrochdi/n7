package n7.backend.controller;

import n7.backend.entites.FeuilleDeMatch;
import n7.backend.entites.Match;
import n7.backend.service.GestionMatchsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
    origins = { "http://localhost:5173", "http://127.0.0.1:5173" },
    allowedHeaders = "*",
    methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS },
    allowCredentials = "true"
)
@RestController
@RequestMapping("/api/matchs")
public class GestionMatchsController {

    @Autowired
    private GestionMatchsService service;

    // 🔹 GET /api/matchs ➜ tous les matchs
    @GetMapping
    public List<Match> all() {
        return service.getTous();
    }

    // 🔹 GET /api/matchs/prochains ➜ uniquement les prochains
    @GetMapping("/prochains")
    public List<Match> prochains() {
        return service.getProchains();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Match> getById(@PathVariable int id) {
        return service.getById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 POST /api/matchs ➜ créer un nouveau match
    @PostMapping
    public Match creer(@RequestBody Match m) {
        return service.planifier(m);
    }

    // 🔹 PUT /api/matchs/{id} ➜ mise à jour d’un match
    @PutMapping("/{id}")
    public Match maj(@PathVariable int id, @RequestBody Match m) {
        return service.majMatch(id, m);
    }

    // 🔹 DELETE /api/matchs/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable int id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 PUT /api/matchs/{id}/resultat ➜ enregistrer un score
    public record ResultatDTO(Integer scoreEquipe, Integer scoreAdverse) {}

    @PutMapping("/{id}/resultat")
    public Match saisirResultat(@PathVariable int id, @RequestBody ResultatDTO dto) {
        return service.saisirResultat(id, dto.scoreEquipe(), dto.scoreAdverse());
    }

    // 🔹 POST /api/matchs/{id}/feuille ➜ créer une feuille de match
    @PostMapping("/{id}/feuille")
    public FeuilleDeMatch creerFeuille(@PathVariable int id) {
        return service.genererFeuille(id);
    }

    // 🔹 GET /api/matchs/{id}/feuille ➜ récupérer une feuille de match
    @GetMapping("/{id}/feuille")
    public FeuilleDeMatch getFeuille(@PathVariable int id) {
        return service.getFeuille(id);
    }
}
