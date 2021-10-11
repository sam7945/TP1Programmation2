/**
 * @Auteur Samuel Dextraze
 * @Auteur  Christophe Cloutier
 */
public class CalculsK1 extends Calculs {

    /**
     * Calcule la valeur du polynome permettant de trouver
     * les coordonnées du nouveau  lorsque k=1.
     *
     * @param original array des coordonnées originales.
     * @param prime array des nouvelles coordonnées.
     * @param i compteur pour la point i.
     * @param j compteur pour le point j.
     * @param h la distance entre les x originaux.
     * @return la valeur du polynome.
     */
    @Override
    public double calculPolynome(Coordonnee[] original, Coordonnee[] prime,
                                 int i, int j, double h)
    {
        double pOne = original[i + 1].getY() - original[i].getY();
        double a = pOne / h;
        double b =
                original[i].getY() - (a * original[i].getX());
        return a * (prime[j].getX()) + b;
    }
}
