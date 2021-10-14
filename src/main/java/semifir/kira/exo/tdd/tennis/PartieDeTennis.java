package semifir.kira.exo.tdd.tennis;

/**
 * Représente une partie entre deux joueurs de tennis.
 */
public class PartieDeTennis {

    private JoueurDeTennis joueurDeTennis1,joueurDeTennis2;

    public PartieDeTennis(JoueurDeTennis joueurDeTennis1, JoueurDeTennis joueurDeTennis2) {
        this.joueurDeTennis1 = joueurDeTennis1;
        this.joueurDeTennis2 = joueurDeTennis2;
    }

    public JoueurDeTennis getJoueur1() {
        return joueurDeTennis1;
    }

    public JoueurDeTennis getJoueur2() {
        return joueurDeTennis2;
    }
}
