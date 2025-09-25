package n7.backend.entites;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public boolean isArchived() {
        return archived;
    }
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private int maillot;
    private String equipe;
    private boolean archived = false;
    private LocalDate datenaissance;
    @OneToMany(mappedBy = "joueur")
    private List<Statistique> statistiques;
    @OneToMany(mappedBy = "joueur")
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
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public int getMaillot() {
        return maillot;
    }
    public void setMaillot(int maillot) {
        this.maillot = maillot;
    }
    public String getEquipe() {
        return equipe;
    }
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
    public LocalDate getDatenaissance() {
        return datenaissance;
    }
    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }
    public List<Statistique> getStatistiques() {
        return statistiques;
    }
    public void setStatistiques(List<Statistique> statistiques) {
        this.statistiques = statistiques;
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
