package n7.backend.entites;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Terrain {

    @Id
    private String id;

    private String nom;
    private String adresse;
    private int capacite;

    @OneToMany(mappedBy = "terrain")
    private List<SessionEntrainement> sessions;

    @OneToMany(mappedBy = "terrain")
    private List<Match> matchs;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public List<SessionEntrainement> getSessions() {
        return sessions;
    }
    public void setSessions(List<SessionEntrainement> sessions) {
        this.sessions = sessions;
    }
    public List<Match> getMatchs() {
        return matchs;
    }
    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }
}
