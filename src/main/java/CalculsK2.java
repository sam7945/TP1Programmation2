/**
 * @Auteur Samuel Dextraze
 * @Auteur Christophe Cloutier
 */
public class CalculsK2 extends Calculs {

    /**
     * Calcule la valeur du polynome permettant de trouver
     * les coordonnées du nouveau  lorsque k=2.
     *
     * @param original array des coordonnées originales.
     * @param prime    array des nouvelles coordonnées.
     * @param i        compteur pour la point i.
     * @param j        compteur pour le point j.
     * @param h        la distance entre les x originaux.
     * @param iMax
     * @return la valeur du polynome.
     */
    @Override
    public double calculPolynome(Coordonnee[] original, Coordonnee[] prime, int i, int j, double h, int iMax) {
        int i1 = i;

        while (i1 + 2 >= iMax)
            i1 -= 1;

        double pOne = original[i1 + 1].getY() - original[i1].getY();
        double pOnePlusOne = original[i1 + 2].getY() - original[i1 + 1].getY();

        double pTwo = pOnePlusOne - pOne;
        double a = (pTwo / (2 * Math.pow(h, 2)));
        double b = (pOne / h) - a * (original[i1].getX() + original[i1 + 1].getX());
        double c = original[i1].getY() - b * original[i1].getX() - a * Math.pow(original[i1].getX(), 2);

        return a * Math.pow(prime[j].getX(), 2) + b * (prime[j].getX()) + c;
    }
}
