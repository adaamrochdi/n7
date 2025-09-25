package n7.backend.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String poste;
    private int datenaissance;
    
    @OneToMany(mappedBy = "staff")
    private List<Contrat> contrats;
    
    @ManyToMany
    @JoinTable(
        name = "joueur_match", 
        joinColumns = @JoinColumn(name = "joueur_id"), 
        inverseJoinColumns = @JoinColumn(name = "match_id") 
    )
    private List<Match> matchs;

    @ManyToMany
    @JoinTable(
        name = "joueur_session", 
        joinColumns = @JoinColumn(name = "joueur_id"), 
        inverseJoinColumns = @JoinColumn(name = "session_id") 
    )
    private List<SessionEntrainement> sessionEntrainements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(int datenaissance) {
        this.datenaissance = datenaissance;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public List<SessionEntrainement> getSessionEntrainements() {
        return sessionEntrainements;
    }

    public void setSessionEntrainements(List<SessionEntrainement> sessionEntrainements) {
        this.sessionEntrainements = sessionEntrainements;
    }

    
    
   
}