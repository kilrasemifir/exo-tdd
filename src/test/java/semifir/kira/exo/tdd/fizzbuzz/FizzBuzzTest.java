package semifir.kira.exo.tdd.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @DisplayName("Si l'index est multiple de fizz et de buzz, allors le r�sultat est FizzBuzz")
    @ParameterizedTest()
    @CsvSource({"1,4", "1,1", "5,5", "3,5"})
    public void testFizzetBuzz(String fizz, String buzz){
        // GIVEN
        int valeurMaximum = 100;
        int valeurFizz = Integer.parseInt(fizz);
        int valeurBuzz = Integer.parseInt(buzz);
        FizzBuzz fizzBuzz = new FizzBuzz();

        // WHEN
        List<String> results = fizzBuzz.run(valeurMaximum, valeurFizz, valeurBuzz);

        // THEN
        assertEquals("FizzBuzz", results.get(valeurFizz*valeurBuzz));
    }

    @DisplayName("Si fizz ou buzz est �gale a 0, alors une exception est lev�")
    @ParameterizedTest()
    @CsvSource({"0,2", "1,0", "0,0"})
    public void testFizzOuBuzzNonNull(String fizz, String buzz){
        // GIVEN
        int valeurMaximum = 100;
        int valeurFizz = Integer.parseInt(fizz);
        int valeurBuzz = Integer.parseInt(buzz);
        FizzBuzz fizzBuzz = new FizzBuzz();

        // WHEN
        //List<String> results = fizzBuzz.run(valeurMaximum, valeurFizz, valeurBuzz);

        // THEN
        assertThrows(FizzBuzzMauvaisArgumentException.class, ()->fizzBuzz.run(valeurMaximum, valeurFizz, valeurBuzz));
    }

    @DisplayName("Si l'index est multiple de fizz, alors le r�sultat est Fizz")
    @ParameterizedTest()
    @CsvSource({"1,4", "1,1", "5,5", "3,5"})
    public void tetFizz(String fizz, String buzz){
        // GIVEN
        int valeurMaximum = 100;
        int valeurFizz = Integer.parseInt(fizz);
        int valeurBuzz = Integer.parseInt(buzz);
        FizzBuzz fizzBuzz = new FizzBuzz();

        // WHEN
        List<String> results = fizzBuzz.run(valeurMaximum, valeurFizz, valeurBuzz);

        // THEN
        assertTrue(results.get(valeurFizz).contains("Fizz"));
    }

    @DisplayName("Si l'index est multiple de buzz, alors le r�sultat est Buzz")
    @ParameterizedTest()
    @CsvSource({"1,4", "1,1", "5,5", "3,5"})
    public void tetBuzz(String fizz, String buzz){
        // GIVEN
        int valeurMaximum = 100;
        int valeurFizz = Integer.parseInt(fizz);
        int valeurBuzz = Integer.parseInt(buzz);
        FizzBuzz fizzBuzz = new FizzBuzz();

        // WHEN
        List<String> results = fizzBuzz.run(valeurMaximum, valeurFizz, valeurBuzz);

        // THEN
        assertTrue(results.get(valeurBuzz).contains("Buzz"));
    }

    @DisplayName("Si valeurMaximum est n�gative, alors l�ve une exception.")
    @ParameterizedTest()
    @ValueSource(ints = {-10, -100, -33, -190})
    public void testValeurMaximumPositif(int valeurMaximum){
        // GIVEN : Dans quel environment je lance le test
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThrows(FizzBuzzMauvaisArgumentException.class, ()->fizzBuzz.run(valeurMaximum, 3, 6));

    }
}