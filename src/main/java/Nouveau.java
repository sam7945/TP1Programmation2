/**
 * @Auteur Samuel Dextraze
 */
public class Nouveau {
    //nb de valeur necessaire calculé
    private int nbValeurM;
    //Distance entres 2 x après rééchantillonage, a prendre dans le fichier
    private double distHPrime;

    private void calculM(double h, double nbValeur) {
        nbValeurM = (int) (((nbValeur - 1) * h) / distHPrime) + 1;
    }

}
