package semifir.kira.exo.tdd.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test pour la fonctionnalit� FizzBuzz")
class FizzBuzzTest {


    @DisplayName("Le r�sultat a une taille �gale � valeurMaximum.")
    @ParameterizedTest()
    @ValueSource(ints = {0, 100, 33, 190})
    public void testTailleDeRetour(int valeurMaximum){
        // GIVEN : Dans quel environment je lance le test
        FizzBuzz fizzBuzz = new FizzBuzz();

        // WHEN : Quand je fais une certaine action
        List<String> results = fizzBuzz.run(valeurMaximum, 3, 7);

        // THEN : alors je veux avoir comme r�ponse
        assertEquals(valeurMaximum, results.size());
    }
}