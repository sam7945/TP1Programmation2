/**
 * @Auteur Samuel Dextraze
 * @Auteur Christophe Cloutier
 */
public class CalculsK3 extends Calculs {

    /**
     * Calcule la valeur du polynome permettant de trouver
     * les coordonnées du nouveau  lorsque k=3.
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

        while (i1 + 3 >= original.length)
            i1 -= 1;

        double pOne = original[i1 + 1].getY() - original[i1].getY();
        double pOnePlusOne = original[i1 + 2].getY() - original[i1 + 1].getY();
        double pOnePlusTwo = original[i1 + 3].getY() - original[i1 + 2].getY();

        double pTwo = pOnePlusOne - pOne;
        double pTwoPlusOne = pOnePlusTwo - pOnePlusOne;
        double pThree = pTwoPlusOne - pTwo;
        double a = pThree / (6 * Math.pow(h, 3));
        double b = (pTwo / (2 * Math.pow(h, 2))) - a * (original[i1].getX() +
                original[i1 + 1].getX() + original[i1 + 2].getX());

        double c = (pOne / h) - b * (original[i1].getX() + original[i1 + 1].getX()) -
                a * (Math.pow(original[i1].getX(), 2) +
                        original[i1].getX() * original[i1 + 1].getX() +
                        Math.pow(original[i1 + 1].getX(), 2));
        double d =
                original[i1].getY() - c * original[i1].getX() -
                        b * Math.pow(original[i1].getX(), 2) -
                        a * Math.pow(original[i1].getX(), 3);

        return a * Math.pow(prime[j].getX(), 3) + b * Math.pow(prime[j].getX(), 2) + c * prime[j].getX() + d;
    }
}
