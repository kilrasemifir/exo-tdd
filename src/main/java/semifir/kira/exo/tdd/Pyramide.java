
package semifir.kira.exo.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Pyramide {

    /**
     * Cette méthode retourne une liste de String représentant une pyramide d'etoile.
     * <p>
     * pyramide(3) -> [ *, **, ***, **, * ]
     * <p>
     * Elle doit retourner une liste de String
     * Elle doit avoir une certaine taille (pour une taille de 3 elle doit avoir une longueur de 5 String)
     * Ses elements doivent etre composés uniquement d'étoile
     * ...
     *
     * @param taille de l'element le plus grand de la pyramide.
     * @return
     */
    public List<String> pyramide(int taille) {

        verificationTailleVailide(taille);

        List<String> result = new ArrayList<>();
        creationFaceCroissante(taille, result);

        creationFaceDecroissante(taille, result);

        return result;
    }

    private void creationFaceDecroissante(int taille, List<String> result) {
        for (int numeroLigne = taille-1; numeroLigne>0; numeroLigne--){
            result.add("*".repeat(numeroLigne));
        }
    }

    private void creationFaceCroissante(int taille, List<String> result) {
        for (int numeroLigne = 0; numeroLigne< taille; numeroLigne++){
            result.add("*".repeat(numeroLigne+1));
        }
    }

    private void verificationTailleVailide(int taille) {
        if (taille <1)
            throw new PyramideBadArgumentException("La taille de la pyramide doit être supérieur ou égale a 1, ici elle est de "+ taille);
    }

    public static void main(String[] args) {
        System.out.println(new Pyramide().pyramide(5));
    }

}
