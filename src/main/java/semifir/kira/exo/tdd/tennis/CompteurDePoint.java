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
}
