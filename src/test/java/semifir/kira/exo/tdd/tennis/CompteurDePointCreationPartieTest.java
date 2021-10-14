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

}