/**
 * @Auteur Samuel Dextraze
 * @Auteur Christophe Cloutier
 */

public class Coordonnee {
    private double X;
    private double Y;
    private int position;

    public Coordonnee(double x, double y, int position) {
        setX(x);
        setY(y);
        setPosition(position);
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
