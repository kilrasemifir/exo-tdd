package semifir.kira.exo.tdd.tennis;

/**
 * Représente une partie entre deux joueurs de tennis.
 */
public class PartieDeTennis {

    private JoueurDeTennis joueurDeTennis1,joueurDeTennis2;
    private ScoreTennis scoreJoueur1, scoreJoueur2;

    public PartieDeTennis(JoueurDeTennis joueurDeTennis1, JoueurDeTennis joueurDeTennis2) {
        this.joueurDeTennis1 = joueurDeTennis1;
        this.joueurDeTennis2 = joueurDeTennis2;
        this.scoreJoueur1 = new ScoreTennis();
        this.scoreJoueur2 = new ScoreTennis();
    }

    public JoueurDeTennis getJoueur1() {
        return joueurDeTennis1;
    }

    public JoueurDeTennis getJoueur2() {
        return joueurDeTennis2;
    }

    public ScoreTennis getScoreJoueur1() {
        return scoreJoueur1;
    }

    public ScoreTennis getScoreJoueur2() {
        return scoreJoueur2;
    }
}
