/**
 * @Auteur Samuel Dextraze
 */
public class Original {
    //Nombre de valeur total
    private int n;
    //entre 1 et 3 inclusivement
    private int degreK;
    //ordonnée première valeur
    private double x0;
    //distance entre 2 variable x
    private double distanceH;
    //y donnée dans le fichier, x doit être calculé(𝑥𝑖 = 𝑥0 + 𝑖 × ℎ),i=nième
    // données
    private Coordonnees[] coordonnees;


    public double calculM(int n, double h, double hPrime) {
        return (((n - 1) * h) / hPrime) + 1;
    }
}
