import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Auteur Samuel Dextraze
 * @auteur Christophe Cloutier
 */
public class Nouveau {

    private int nbValeurM;
    private double distHPrime;
    private ArrayList<Coordonnee> coordonnees;
    private static Nouveau nouveau;

    private Nouveau() {
        coordonnees = new ArrayList<>();
    }

    /**
     * Crée une instance des nouveaux points seulement si
     * celle-ci n'a pas été créé. Retourne la même instance
     * si jamais la méthode est rappelée.
     *
     * @return Retourne l'objet d'instance.
     */
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
        int nbOriginal = original.getCoordonnees().size();
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
                    original.getDistanceH(), nbOriginal));
        }
    }


    public ArrayList<Coordonnee> getCoordonnees() {
        return coordonnees;
    }

    public void setDistHPrime(double distHPrime) {
        this.distHPrime = distHPrime;
    }

}
