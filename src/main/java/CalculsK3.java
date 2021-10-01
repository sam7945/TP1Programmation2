/**
 * @Auteur Samuel Dextraze
 */
public class CalculsK3 extends Calculs {
    @Override
    public double calculPolynome(Coordonnees[] original, Coordonnees[] prime, int i, int j, double h) {
        double pOne = original[i + 1].getY() - original[i].getY();
        double pOnePlusOne = original[i + 2].getY() - original[i + 1].getY();
        double pOnePlusTwo = original[i + 3].getY() - original[i + 2].getY();

        double pTwo = pOnePlusOne - pOne;
        double pTwoPlusOne = pOnePlusTwo - pOnePlusOne;
        double pThree = pTwoPlusOne - pTwo;
        double a = pThree / (6 * Math.pow(h, 3));
        double b = (pTwo / (2 * Math.pow(h, 2))) - a * (original[i].getX() +
                original[i + 1].getX() + original[i + 2].getX());

        double c = (pOne / h) - b * (original[i].getX() + original[i + 1].getX()) -
                a * (Math.pow(original[i].getX(), 2) +
                        original[i].getX() * original[i + 1].getX() +
                        Math.pow(original[i + 1].getX(), 2));
        double d =
                original[i].getY() - c * original[i].getX() -
                        b * Math.pow(original[i].getX(), 2) -
                        a * Math.pow(original[i].getX(), 3);

        return a * Math.pow(prime[j].getX(), 3) + b * Math.pow(prime[j].getX(), 2) + c * prime[j].getX() + d;
    }
}