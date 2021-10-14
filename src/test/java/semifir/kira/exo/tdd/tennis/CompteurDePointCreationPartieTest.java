package semifir.kira.exo.tdd.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Création d'une partie de tennis")
class CompteurDePointCreationPartieTest {

    @Test
    @DisplayName("Un utilisateur peut créer une nouvelle partie")
    public void testNouvellePartie(){
        // GIVEN
        CompteurDePoint compteurDePoint = new CompteurDePoint();

        // WHEN
        PartieDeTennis partieDeTennis = compteurDePoint.creerNouvellePartie();

        // THEN
        assertNotNull(partieDeTennis);
    }

}