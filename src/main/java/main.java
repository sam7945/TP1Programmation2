import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Calculs c = new CalculsK1();
        ArrayList<Coordonnees> array = new ArrayList<>();
        c.calculPolynome((Coordonnees[]) array.toArray(),(Coordonnees[]) array.toArray(),20,20,20.0);
    }
}
