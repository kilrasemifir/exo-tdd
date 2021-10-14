package semifir.kira.exo.exceptions;

public class ExempleDExceptions {

    /**
     * Cette methode l�ve une exception de type {@link RuntimeException}.
     * Une Exception enfant de {@link RuntimeException} n'a pas besoin d'etre sp�cifi� dans
     * tout l'arbre d'appel de la m�thode.
     * </br>
     * On appel ce type d'exception (Toute les classes enfants de RuntimeException) d'est <b>Unchecked Exception</b>
     * car elle sont g�r� par java lors de l'ex�cution et ne n�cessite pas au d�veloppeur sp�cifi� quand elle seront
     * g�r�.
     * </br>
     * Pour g�rer un <b>Unchecked Exception</b> vous devez toujours utiliser le block de control try{}catch{}
     * </br>
     * {@link RuntimeException} est un enfant de {@link Exception}!
     */
    public void throwUncheckedException(){
        throw new RuntimeException("Unchecked exception");
    }

    /**
     * Cette methode l�ve une exceptopn de type {@link Exception}.
     * Une exception qui n'est pas une {@link RuntimeException} est une exception qu'il laisse une trace sur toutes les signature de m�thode jusqu'�
     * sa r�cup�ration par un bloque try{}catch{}.
     *
     * Il est pr�f�rable d'utiliser plut�t des <b>Unchecked Exception</b> qui sont plus facile � g�r� et rende le code plus
     * facile a faire �volu�.
     */
    public void throwCheckedException() throws Exception{
        throw new Exception("Checked exception");
    }

    /**
     * Cette m�thode a besoin de definir throws Exception dans sa signature car une m�thode qu'elle appel
     * l�ve une Checked Exception.
     */
    public void appelCheckedException() throws Exception {
        throwCheckedException();
    }

    /**
     * Cette m�thode n'a pas besoin d'ajouter un throws dans sa signature car les m�thodes qu'elle appelle
     * ne l�ve aucune Checked Exception.
     */
    public void appelUncheckedException() {
        throwUncheckedException();
    }

    /**
     * Cette m�thode g�re les deux types d'exception.
     *
     * Les Unchecked et les Checked sont g�r� de la m�me mani�re.
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
