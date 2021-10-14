package semifir.kira.exo.tdd.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Quand un joueur gagne un point")
class CompteurDePointGagnerPointTest {
    JoueurDeTennis joueurDeTennis1 = new JoueurDeTennis();
    JoueurDeTennis joueurDeTennis2 = new JoueurDeTennis();
    CompteurDePoint compteurDePoint = new CompteurDePoint();

    @Test
    @DisplayName("Un joueur gagne un point")
    public void testGagneUnPoint(){
        // GIVEN
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);
        // WHEN
        compteurDePoint.gagnerUnPoint(partieDeTennis, joueurDeTennis1);
        // THEN
        assertNotEquals(0, partieDeTennis.getScoreJoueur1().getPoint());
        // WHEN
        compteurDePoint.gagnerUnPoint(partieDeTennis, joueurDeTennis2);
        // THEN
        assertNotEquals(0, partieDeTennis.getScoreJoueur2().getPoint());
    }

    @ParameterizedTest()
    @CsvSource({"0,0,15","15,0,30","30,0,40", "15,15,30", "30,15,40", "15,40,30"})
    @DisplayName("Quand le joueur 1 gagne un point, il passe de 0 à 15. Puis de 15 à 30. Puis de 30 à 40.")
    public void testGagneUnPointJoueur1(String pointsJoueur1Str, String pointsJoueur2Str, String pointsGagnantStr){

        // GIVEN
        int pointsJoueur1 = Integer.parseInt(pointsJoueur1Str);
        int pointsJoueur2 = Integer.parseInt(pointsJoueur2Str);
        int pointsGagnant = Integer.parseInt(pointsGagnantStr);
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);
        partieDeTennis.getScoreJoueur1().setPoint(pointsJoueur1);
        partieDeTennis.getScoreJoueur2().setPoint(pointsJoueur2);
        // WHEN
        compteurDePoint.gagnerUnPoint(partieDeTennis, joueurDeTennis1);
        // THEN
        assertEquals(pointsGagnant, partieDeTennis.getScoreJoueur1().getPoint());
        assertEquals(pointsJoueur2, partieDeTennis.getScoreJoueur2().getPoint());
    }

    @ParameterizedTest()
    @CsvSource({"0,0,15","15,0,30","30,0,40", "15,15,30", "30,15,40", "15,40,30"})
    @DisplayName("Quand le joueur 2 gagne un point, il passe de 0 à 15. Puis de 15 à 30. Puis de 30 à 40.")
    public void testGagneUnPointJoueur2(String pointsJoueur2Str, String pointsJoueur1Str, String pointsGagnantStr){

        // GIVEN
        int pointsJoueur1 = Integer.parseInt(pointsJoueur1Str);
        int pointsJoueur2 = Integer.parseInt(pointsJoueur2Str);
        int pointsGagnant = Integer.parseInt(pointsGagnantStr);
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);
        partieDeTennis.getScoreJoueur1().setPoint(pointsJoueur1);
        partieDeTennis.getScoreJoueur2().setPoint(pointsJoueur2);
        // WHEN
        compteurDePoint.gagnerUnPoint(partieDeTennis, joueurDeTennis2);
        // THEN
        assertEquals(pointsGagnant, partieDeTennis.getScoreJoueur2().getPoint());
        assertEquals(pointsJoueur1, partieDeTennis.getScoreJoueur1().getPoint());
    }

    @Test
    @DisplayName("Si les deux joueurs sont a egalité a 40 points, si aucun joueur a un avantage, le joueur qui gagne le point gagne un avantage.")
    public void testJoueur1Avantage(){

        // GIVEN
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie(joueurDeTennis1, joueurDeTennis2);
        partieDeTennis.getScoreJoueur1().setPoint(40);
        partieDeTennis.getScoreJoueur2().setPoint(40);
        // WHEN
        compteurDePoint.gagnerUnPoint(partieDeTennis, joueurDeTennis1);
        // THEN
        assertTrue(partieDeTennis.getScoreJoueur1().isAvantage());
        assertFalse(partieDeTennis.getScoreJoueur2().isAvantage());

        partieDeTennis.getScoreJoueur1().setPoint(40);
        partieDeTennis.getScoreJoueur2().setPoint(40);
        partieDeTennis.getScoreJoueur1().setAvantage(false);
        // WHEN
        compteurDePoint.gagnerUnPoint(partieDeTennis, joueurDeTennis2);
        // THEN
        assertTrue(partieDeTennis.getScoreJoueur2().isAvantage());
        assertFalse(partieDeTennis.getScoreJoueur1().isAvantage());
    }


}