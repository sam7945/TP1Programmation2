/**
 * @Auteur Samuel Dextraze
 */
public class CalculsK1 extends Calculs {

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
