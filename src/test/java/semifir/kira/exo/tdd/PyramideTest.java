package semifir.kira.exo.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test {@link Pyramide}
 */
@DisplayName("Lors de la création d'une pyramide")
class PyramideTest {

    static Pyramide pyramide = new Pyramide();

    /**
     * Unit test {@link Pyramide#pyramide(int)}
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 23})
    @DisplayName("Elle doit retourner une liste de String non vide")
    public void testListeDEString(int taille){
        List<String> result = pyramide.pyramide(taille);

        assertNotNull(result);
        for (String s : result) {
            assertNotNull(s);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 23})
    @DisplayName("Elle doit retourner une liste de longueur (taille)*2-1")
    public void testBonneLangueur(int taille){
        List<String> result = pyramide.pyramide(taille);
        assertEquals(taille*2-1, result.size());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -21, 0})
    @DisplayName("Elle doit retourner une exception si la taille est inférieur ou égale a 0")
    public void testExceptionSiOOuInf(int taille){
        assertThrows(PyramideBadArgumentException.class, ()->pyramide.pyramide(taille));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 23})
    @DisplayName("Les String sont composé d'*")
    public void testChaineDEtoiles(int taille){
        List<String> result = pyramide.pyramide(taille);
        for (String s : result) {
            assertTrue(s.matches("^[*]+$"));
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7, 23})
    @DisplayName("Les String ont une longueur inférieur ou égale a taille")
    public void testLongueurString(int taille){
        List<String> result = pyramide.pyramide(taille);
        assertEquals(taille, result.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7, 23})
    @DisplayName("La pyramide a une face croissante")
    public void testFaceCroissante(int taille){
        List<String> result = pyramide.pyramide(taille);
        System.out.println(result);
        for (int numeroLigne = 1; numeroLigne <= taille; numeroLigne++) {
            assertEquals(numeroLigne, result.get(numeroLigne-1).length());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 7, 23})
    @DisplayName("La pyramide a une face décroissante apres son sommet")
    public void testFaceDeroissante(int taille){
        List<String> result = pyramide.pyramide(taille);
        System.out.println(result);
        int pyramideLargeur = taille*2-1;
        for (int numeroLigne = 0; numeroLigne < taille; numeroLigne++) {
            assertEquals(numeroLigne+1, result.get(pyramideLargeur - numeroLigne-1).length());
        }
    }
}