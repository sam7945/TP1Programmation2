import java.util.ArrayList;

/**
 * @Auteur Samuel Dextraze
 */
public class Nouveau {
    //nb de valeur necessaire calculé
    private int nbValeurM;
    //Distance entres 2 x après rééchantillonage, a prendre dans le fichier
    private double distHPrime;
    private ArrayList<Coordonnees> coordonnees;
    private static Nouveau nouveau;

    private Nouveau() {
        coordonnees = new ArrayList<>();
    }

    public static Nouveau instanceNouveau(){
        if(nouveau == null)
            nouveau = new Nouveau();
        return nouveau;
    }

    private void calculM(double h, double nbValeur) {
        nbValeurM = (int) (((nbValeur - 1) * h) / distHPrime) + 1;
        coordonnees = new ArrayList<>();
    }

    public int getNbValeurM() {
        return nbValeurM;
    }

    public void setNbValeurM(int nbValeurM) {
        this.nbValeurM = nbValeurM;
    }

    public double getDistHPrime() {
        return distHPrime;
    }

    public void setDistHPrime(double distHPrime) {
        this.distHPrime = distHPrime;
    }

}
