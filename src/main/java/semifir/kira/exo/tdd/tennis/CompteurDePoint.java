package semifir.kira.exo.tdd.tennis;

/**
 * Classe permettant de compter les points au tennis.
 */
public class CompteurDePoint {

    /**
     * Créer une nouvelle partie de tennis.
     * @param joueurDeTennis1 premier joueur de la partie
     * @param joueurDeTennis2 deuxieme joueur de la partie
     * @return la nouvelle partie de tennis
     */
    public PartieDeTennis creerNouvellePartie(JoueurDeTennis joueurDeTennis1, JoueurDeTennis joueurDeTennis2) {
        return new PartieDeTennis(joueurDeTennis1, joueurDeTennis2);
    }

    /**
     * Cette methode permet de modifier les scores des joueurs en fonction du joueur qui a gagné le point.
     * @param partieDeTennis la partie sur la quel le point est gagné
     * @param gagnant le joueur qui a gagné
     */
    public void gagnerUnPoint(PartieDeTennis partieDeTennis, JoueurDeTennis gagnant){
        ScoreTennis scoreJoueur1 = partieDeTennis.getScoreJoueur1();
        ScoreTennis scoreJoueur2 = partieDeTennis.getScoreJoueur2();
        ScoreTennis scoreGagnant = chercherLeScoreGagnant(partieDeTennis, gagnant, scoreJoueur1, scoreJoueur2);

        calculerPoint(scoreGagnant);
    }

    private void calculerPoint(ScoreTennis scoreGagnant) {
        if (scoreGagnant.getPoint() == 0){
            scoreGagnant.setPoint(15);
        } else if (scoreGagnant.getPoint() == 15){
            scoreGagnant.setPoint(30);
        } else if (scoreGagnant.getPoint() == 30){
            scoreGagnant.setPoint(40);
        }
    }

    private ScoreTennis chercherLeScoreGagnant(PartieDeTennis partieDeTennis, JoueurDeTennis gagnant, ScoreTennis scoreJoueur1, ScoreTennis scoreJoueur2) {
        ScoreTennis scoreGagnant;
        if (gagnant == partieDeTennis.getJoueur1())
            scoreGagnant = scoreJoueur1;
        else
            scoreGagnant = scoreJoueur2;
        return scoreGagnant;
    }
}
