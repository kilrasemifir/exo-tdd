package semifir.kira.exo.exceptions;

public class ExempleDExceptions {

    /**
     * Cette methode lève une exception de type {@link RuntimeException}.
     * Une Exception enfant de {@link RuntimeException} n'a pas besoin d'etre spécifié dans
     * tout l'arbre d'appel de la méthode.
     * </br>
     * On appel ce type d'exception (Toute les classes enfants de RuntimeException) d'est <b>Unchecked Exception</b>
     * car elle sont géré par java lors de l'exécution et ne nécessite pas au développeur spécifié quand elle seront
     * géré.
     * </br>
     * Pour gérer un <b>Unchecked Exception</b> vous devez toujours utiliser le block de control try{}catch{}
     * </br>
     * {@link RuntimeException} est un enfant de {@link Exception}!
     */
    public void throwUncheckedException(){
        throw new RuntimeException("Unchecked exception");
    }

    /**
     * Cette methode lève une exceptopn de type {@link Exception}.
     * Une exception qui n'est pas une {@link RuntimeException} est une exception qu'il laisse une trace sur toutes les signature de méthode jusqu'à
     * sa récupération par un bloque try{}catch{}.
     *
     * Il est préférable d'utiliser plutôt des <b>Unchecked Exception</b> qui sont plus facile à géré et rende le code plus
     * facile a faire évolué.
     */
    public void throwCheckedException() throws Exception{
        throw new Exception("Checked exception");
    }

    /**
     * Cette méthode a besoin de definir throws Exception dans sa signature car une méthode qu'elle appel
     * lève une Checked Exception.
     */
    public void appelCheckedException() throws Exception {
        throwCheckedException();
    }

    /**
     * Cette méthode n'a pas besoin d'ajouter un throws dans sa signature car les méthodes qu'elle appelle
     * ne lève aucune Checked Exception.
     */
    public void appelUncheckedException() {
        throwUncheckedException();
    }

    /**
     * Cette méthode gére les deux types d'exception.
     *
     * Les Unchecked et les Checked sont géré de la même manière.
     */
    public void gestionException(){
        try{
            appelUncheckedException();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
        try {
            appelCheckedException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
