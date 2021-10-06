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

    public void calculM(double h, double nbValeur) {
        nbValeurM = (int) (((nbValeur - 1) * h) / distHPrime) + 1;
    }

    public void calculX(int x0) {
        for (int j = 0; j < nbValeurM; j++) {
            coordonnees.add(new Coordonnee(x0 + j * distHPrime, 0));
        }
    }

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

            double coo =
                    original.getCoordonnees().stream().filter(n -> (n.getX() <= coordonne.getX()))
                            .max(Comparator.comparing(Coordonnee::getX)).orElseThrow().getX();
            int i = (int) coo;

            calculs.calculPolynome(
                    (Coordonnee[]) original.getCoordonnees().toArray(),
                    (Coordonnee[]) getCoordonnees().toArray(), i,
                    (int) coordonne.getX(),
                    original.getDistanceH());
        }
    }




    public ArrayList<Coordonnee> getCoordonnees() {
        return coordonnees;
    }

    public void setDistHPrime(double distHPrime) {
        this.distHPrime = distHPrime;
    }

}
