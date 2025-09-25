package n7.backend.controller;

import n7.backend.entites.Billet;
import n7.backend.service.GestionBilletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
    origins = { "http://localhost:5173", "http://127.0.0.1:5173" },
    allowedHeaders = "*",
    methods = {
      RequestMethod.GET,
      RequestMethod.POST,
      RequestMethod.PUT,
      RequestMethod.DELETE,
      RequestMethod.OPTIONS
    },
    allowCredentials = "true"
)
@RestController
@RequestMapping("/api/tickets")
public class GestionBilletsController {

    @Autowired
    private GestionBilletsService service;

    // GET /api/tickets → liste de tous les billets
    @GetMapping
    public List<Billet> getAll() {
        return service.getTousLesBillets();
    }

    // GET /api/tickets/{id} → un billet par id
    @GetMapping("/{id}")
    public ResponseEntity<Billet> getById(@PathVariable int id) {
        return service.getBilletById(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // DTO minimal pour la création/modification
    public record BilletDTO(Integer matchId, String categorie, Float prix) {}

    // POST /api/tickets → créer un billet
    @PostMapping
    public Billet create(@RequestBody BilletDTO dto) {
        return service.creerBillet(dto.matchId(), dto.categorie(), dto.prix());
    }

    // PUT /api/tickets/{id} → mettre à jour un billet
    @PutMapping("/{id}")
    public Billet update(@PathVariable int id, @RequestBody BilletDTO dto) {
        return service.majBillet(id, dto.matchId(), dto.categorie(), dto.prix());
    }

    // DELETE /api/tickets/{id} → supprimer un billet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.supprimerBillet(id);
        return ResponseEntity.noContent().build();
    }
}
