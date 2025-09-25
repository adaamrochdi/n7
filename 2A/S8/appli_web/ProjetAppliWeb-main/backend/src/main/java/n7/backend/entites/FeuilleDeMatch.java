package n7.backend.entites;

import jakarta.persistence.*;
@Entity
public class FeuilleDeMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    private Match match;

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

}