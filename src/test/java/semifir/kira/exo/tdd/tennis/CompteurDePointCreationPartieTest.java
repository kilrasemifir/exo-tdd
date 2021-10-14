package semifir.kira.exo.tdd.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Création d'une partie de tennis")
class CompteurDePointCreationPartieTest {

    JoueurDeTennis joueurDeTennis1 = new JoueurDeTennis();
    JoueurDeTennis joueurDeTennis2 = new JoueurDeTennis();
    @Test
    @DisplayName("Un utilisateur peut créer une nouvelle partie")
    public void testNouvellePartie(){
        // GIVEN
        CompteurDePoint compteurDePoint = new CompteurDePoint();

        // WHEN
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);

        // THEN
        assertNotNull(partieDeTennis);
    }

    @Test
    @DisplayName("Un utilisateur peut créer une nouvelle partie")
    public void testChoixDesJoueur(){
        // GIVEN
        CompteurDePoint compteurDePoint = new CompteurDePoint();

        // WHEN
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);

        // THEN
        assertEquals(joueurDeTennis1, partieDeTennis.getJoueur1());
        assertEquals(joueurDeTennis2, partieDeTennis.getJoueur2());
    }

    @Test
    @DisplayName("Au début de la partie les deux joueurs ont 0 points, jeux et sets.")
    public void testDebut0PointJeuxSet(){
        // GIVEN
        CompteurDePoint compteurDePoint = new CompteurDePoint();

        // WHEN
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);
        final ScoreTennis scoreJoueur1 = partieDeTennis.getScoreJoueur1();
        final ScoreTennis scoreJoueur2 = partieDeTennis.getScoreJoueur2();

        // THEN
        assertEquals(0, scoreJoueur1.getPoint());
        assertEquals(0, scoreJoueur2.getPoint());
        assertEquals(0, scoreJoueur1.getJeu());
        assertEquals(0, scoreJoueur2.getJeu());
        assertEquals(0, scoreJoueur1.getSet());
        assertEquals(0, scoreJoueur2.getSet());

    }

}