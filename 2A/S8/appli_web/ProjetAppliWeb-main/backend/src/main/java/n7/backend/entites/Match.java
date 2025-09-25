package n7.backend.entites;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import n7.backend.entites.enums.StatutMatch;
import jakarta.persistence.*;

@Entity
@Table(name = "matchs")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime heureDebut;
    
    @JsonFormat(pattern = "HH:mm")
    private LocalTime heureFin;

    @ManyToOne
    private Terrain terrain;

    private String adversaire;

    @ManyToMany
    private List<Joueur> joueursPrincipaux;

    @ManyToMany
    private List<Joueur> joueursSecondaires;

    @ManyToMany
    private List<Staff> staff;

    private String equipe;
    private String resultat;

    @OneToOne(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private FeuilleDeMatch feuilleDeMatch;
    
    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference               // <— on marque le parent
    private List<Billet> billets;
    

    @Enumerated(EnumType.STRING)
    private StatutMatch statut = StatutMatch.PLANNED;

    private Integer scoreEquipe;
    private Integer scoreAdverse;


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeureDebut() { return heureDebut; }
    public void setHeureDebut(LocalTime heureDebut) { this.heureDebut = heureDebut; }

    public LocalTime getHeureFin() { return heureFin; }
    public void setHeureFin(LocalTime heureFin) { this.heureFin = heureFin; }

    public Terrain getTerrain() { return terrain; }
    public void setTerrain(Terrain terrain) { this.terrain = terrain; }

    public String getAdversaire() { return adversaire; }
    public void setAdversaire(String adversaire) { this.adversaire = adversaire; }

    public List<Joueur> getJoueursPrincipaux() { return joueursPrincipaux; }
    public void setJoueursPrincipaux(List<Joueur> joueursPrincipaux) { this.joueursPrincipaux = joueursPrincipaux; }

    public List<Joueur> getJoueursSecondaires() { return joueursSecondaires; }
    public void setJoueursSecondaires(List<Joueur> joueursSecondaires) { this.joueursSecondaires = joueursSecondaires; }

    public List<Staff> getStaff() { return staff; }
    public void setStaff(List<Staff> staff) { this.staff = staff; }

    public String getEquipe() { return equipe; }
    public void setEquipe(String equipe) { this.equipe = equipe; }

    public String getResultat() { return resultat; }
    public void setResultat(String resultat) { this.resultat = resultat; }

    public FeuilleDeMatch getFeuilleDeMatch() { return feuilleDeMatch; }
    public void setFeuilleDeMatch(FeuilleDeMatch feuilleDeMatch) { this.feuilleDeMatch = feuilleDeMatch; }

    public List<Billet> getBillets() { return billets; }
    public void setBillets(List<Billet> billets) { this.billets = billets; }

    // --- Nouveaux getters / setters ---

    public StatutMatch getStatut() { return statut; }
    public void setStatut(StatutMatch statut) { this.statut = statut; }

    public Integer getScoreEquipe() { return scoreEquipe; }
    public void setScoreEquipe(Integer scoreEquipe) { this.scoreEquipe = scoreEquipe; }

    public Integer getScoreAdverse() { return scoreAdverse; }
    public void setScoreAdverse(Integer scoreAdverse) { this.scoreAdverse = scoreAdverse; }
}
