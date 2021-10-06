import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
        Original original = Original.InstanceOriginal();
        Nouveau nouveau = Nouveau.instanceNouveau();


        double d = 0.0;

        int count = 0;
        try {
            Path path = FileSystems.getDefault().getPath(nom);
            Scanner sc = new Scanner(Files.newBufferedReader(path));
            sc.useLocale( Locale.CANADA );

            while (sc.hasNext())
            {
                if( sc.hasNextInt() ) {
                    original.setDegreK(sc.nextInt());
                    count++;
                }
                if( sc.hasNextDouble() ) {
                    d = sc.nextDouble();
                    switch (count){
                        case 1:
                            original.setX0(d);
                            break;
                        case 2:
                            original.setDistanceH(d);
                            break;
                        case 3:
                            nouveau.setDistHPrime(d);
                            break;
                        default:
                            original.getCoordonnees().add(new Coordonnee(0,d));
                            break;
                    }
                    count++;
                }
            }
            count -= 4;
            original.setN(count);
            original.getCoordonnees().stream().findFirst().get().setX(original.getX0());
            sc.close();
        } catch ( FileNotFoundException e ) {
            System.err.println("Le fichier spécifié est introuvable.");
        } catch ( IOException e ) {
            System.err.println("Une erreur est survenue lors de la lecture du" +
                    " fichier.");
        }
    }
}
