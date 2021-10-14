package semifir.kira.exo.tdd.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    /**
     * Cette fonction retourne une liste de String contenant les r�sultats de la suite fizzbuzz.
     *
     * Elle poss�de une taille de valeurMaximum.
     * Chaque String suis la r�gle suivante:
     * <ul>
     *     <li>Si l'index du string est multiple de valeurDeFizz et valeurDeBuzz alors il est �gale a FizzBuzz</li>
     *     <li>Sinon si l'index de string est multiple de valeurDeBuzz alors il est �gale a Buzz</li>
     *     <li>Sinon si l'index de string est multiple de valeurDeFizz alors il est �gale a Fizz</li>
     *     <li>Sinon il est �gale a l'index.</li>
     * </ul>
     *
     * @param valeurMaximum valeur jusqu'a la qu'elle aller. Elle repr�sente la taille de la liste de retour.
     *                      Cette valeur ne peut pas etre n�gative.
     * @param valeurDeFizz valeur de fizz.
     *                     Cette valeur ne peut pas �tre n�gative ou nulle.
     * @param valeurDeBuzz valeur de buzz.
     *                     Cette valeur ne peut pas �tre n�gative ou nulle.
     * @return la liste des r�sultats de l'algorithme fizzbuzz.
     */
    public List<String> run(int valeurMaximum, int valeurDeFizz, int valeurDeBuzz){

        verificationValeursFizzEtBuzz(valeurDeFizz, valeurDeBuzz);

        List<String> results = new ArrayList<>();
        for (int index = 0; index < valeurMaximum; index++) {
            if (isMultiple(index, valeurDeFizz*valeurDeBuzz)){
                results.add("FizzBuzz");
            }
            else results.add("");
        }
        return results;
    }

    private void verificationValeursFizzEtBuzz(int valeurDeFizz, int valeurDeBuzz) {
        if (valeurDeFizz ==0 || valeurDeBuzz ==0){
            throw new FizzBuzzMauvaisArgumentException("fizz est buzz ne peuvent pas etre nulle");
        }
    }

    private boolean isMultiple(int valeurATester, int diviseur) {
        return valeurATester % (diviseur) == 0;
    }
}
