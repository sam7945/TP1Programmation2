import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * @Auteur Samuel Dextraze
 */
public class File {

    /**
     * Lis le fichier et récupère les données.
     */
    public static void readFile(){
        String nom = "nom.txt";
        int x = 0;
        double d = 0.0;
        try {
            FileReader fr = new FileReader(nom);
            BufferedReader fichier = new BufferedReader(fr);
            Scanner sc = new Scanner(fichier);
            sc.useLocale( Locale.CANADA );
            if( sc.hasNextInt() ) {
                x = sc.nextInt();
            }
            if( sc.hasNextDouble() ) {
                d = sc.nextDouble();
            }
            sc.close();
        } catch ( FileNotFoundException e ) {
            System.err.println("Le fichier spécifié est introuvable.");
        } catch ( IOException e ) {
            System.err.println("Une erreur est survenue lors de la lecture du" +
                    " fichier.");
        }
    }
}
