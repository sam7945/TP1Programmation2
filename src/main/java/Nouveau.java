import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Auteur Samuel Dextraze
 */
public class Nouveau {
    //nb de valeur necessaire calculé
    private int nbValeurM;
    //Distance entres 2 x après rééchantillonage, a prendre dans le fichier
    private double distHPrime;
    private ArrayList<Coordonnee> coordonnees;
    private static Nouveau nouveau;

    private Nouveau() {
        coordonnees = new ArrayList<>();
    }

    public static Nouveau instanceNouveau() {
        if (nouveau == null)
            nouveau = new Nouveau();
        return nouveau;
    }

    /**
     * Calcule le nombre de points en sortie.
     *
     * @param nbValeur de point original total.
     * @param h        distance entre deux points dans le fichier d'entré.
     */
    public void calculM(double h, double nbValeur) {
        nbValeurM = (int) (((nbValeur - 1) * h) / distHPrime) + 1;
    }

    public void calculCoordonnee(double x0, int k) {
        calculX(x0);
        calculY(k);
    }

    ;

    /**
     * Calcule la valeur du x pour chaque nouveau point et l'ajoute dans un arraylist.
     *
     * @param x0 la valeur du x original.
     */
    private void calculX(double x0) {
        for (int j = 0; j < nbValeurM; j++) {
            coordonnees.add(new Coordonnee(x0 + j * distHPrime, 0, j));
        }
    }

    /**
     * Calcule la valeur du y pour chaque nouveau point et l'ajoute dans un arraylist.
     *
     * @param k la valeur du degré de k.
     */
    private void calculY(int k) {
        Calculs calculs;
        Original original = Original.InstanceOriginal();
        switch (k) {
            case 1:
                calculs = new CalculsK1();
                break;
            case 2:
                calculs = new CalculsK2();
                break;
            default:
                calculs = new CalculsK3();
                break;
        }

        for (Coordonnee coordonne : getCoordonnees()) {

            int i =
                    original.getCoordonnees().stream().filter(n -> (n.getX() <= coordonne.getX()))
                            .max(Comparator.comparing(Coordonnee::getX)).orElseThrow().getPosition();
            Coordonnee[] coordonneesOri = original.getCoordonnees().toArray(new Coordonnee[0]);
            Coordonnee[] coordonneesNou = getCoordonnees().toArray(new Coordonnee[0]);

            coordonne.setY(calculs.calculPolynome(
                    coordonneesOri,
                    coordonneesNou, i,
                    coordonne.getPosition(),
                    original.getDistanceH()));
        }
    }


    public ArrayList<Coordonnee> getCoordonnees() {
        return coordonnees;
    }

    public void setDistHPrime(double distHPrime) {
        this.distHPrime = distHPrime;
    }

}
