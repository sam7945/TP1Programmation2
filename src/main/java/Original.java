import java.util.ArrayList;

/**
 * @Auteur Samuel Dextraze
 * @Auteur Christophe Cloutier
 */

public class Original {

    private int n;
    private int degreK;
    private double x0;
    private double distanceH;
    private ArrayList<Coordonnee> coordonnees;

    private static Original original;

    private Original() {
        coordonnees = new ArrayList<>();
    }

    public static Original InstanceOriginal() {
        if (original == null)
            original = new Original();
        return original;
    }

    /**
     * Calcule la valeur des x originaux et les ajoute dans un objet coordonnée.
     */
    public void calculXi() {
        for (int i = 0; i < coordonnees.size(); i++) {
            coordonnees.get(i).setX(x0 + i * distanceH);
        }
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getDegreK() {
        return degreK;
    }

    public void setDegreK(int degreK) {
        this.degreK = degreK;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getDistanceH() {
        return distanceH;
    }

    public void setDistanceH(double distanceH) {
        this.distanceH = distanceH;
    }

    public ArrayList<Coordonnee> getCoordonnees() {
        return coordonnees;
    }
}
