package n7.backend.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "match_id")
    @JsonBackReference                  // <— on ignore la référence au parent
    private Match match;
    private String categorie;
    private float prix;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Match getMatch() {
        return match;
    }
    public void setMatch(Match match) {
        this.match = match;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
}