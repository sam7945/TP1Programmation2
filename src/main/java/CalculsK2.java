/**
 * @Auteur Samuel Dextraze
 */
public class CalculsK2 extends Calculs {
    @Override
    public double calculPolynome(Coordonnee[] original, Coordonnee[] prime, int i, int j, double h) {
        double pOne =
                original[i + 1].getY() - original[i].getY();
        double pOnePlusOne =
                original[i + 2].getY() - original[i + 1].getY();
        double pTwo = pOnePlusOne - pOne;
        double a = (pTwo / (2 * Math.pow(h, 2)));
        double b = (pOne / h) - a * (original[i].getX() + original[i + 1].getX());
        double c = original[i].getY() - b * original[i].getX() - a * Math.pow(original[i].getX(), 2);

        return a * Math.pow(prime[j].getX(), 2) + b * (prime[j].getX()) + c;
    }
}
