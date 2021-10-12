import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

/**
 * @Auteur Samuel Dextraze
 * @Auteur Christophe Cloutier
 */
public class File {

    /**
     * Lis le fichier en entrée et récupère les données nécessaire au traitement.
     */
    public static void readFile() {
        String nom = demanderNomFichier();

        Original original = Original.InstanceOriginal();
        Nouveau nouveau = Nouveau.instanceNouveau();

        double d = 0.0;
        int count = 0;

        try {
            Path path = FileSystems.getDefault().getPath(nom);
            Scanner sc = new Scanner(Files.newBufferedReader(path));
            sc.useLocale(Locale.CANADA);

            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    original.setDegreK(sc.nextInt());
                    count++;
                } else if (sc.hasNextDouble()) {
                    d = sc.nextDouble();
                    switch (count) {
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
                            original.getCoordonnees().add(new Coordonnee(0, d,
                                    count - 4));
                            break;
                    }
                    count++;
                } else {
                    throw new FileDataException();
                }
            }
            count -= 4;
            original.setN(count);
            Optional<Coordonnee> or = original.getCoordonnees().stream().findFirst();
            or.ifPresent(coordonnee -> coordonnee.setX(original.getX0()));
            if (or.isEmpty())
                throw new NoCoordonatesException();

            original.calculXi();
            nouveau.calculM(original.getDistanceH(), original.getN());
            nouveau.calculCoordonnee(original.getCoordonnees().get(0).getX(),
                    original.getDegreK());
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier spécifié est introuvable.");
        } catch (IOException e) {
            System.err.println("Une erreur est survenue lors de la lecture du" +
                    " fichier.");
        } catch (FileDataException e) {
            System.err.println("Les données du fichier contiennent " +
                    "du texte. Veuillez fournir un fichier conforme.");
        } catch (NoCoordonatesException e) {
            System.err.println("Il n'y a aucune coordonné dans votre fichier!");
        }
    }

    /**
     * Demande à l'utilisateur d'entrer le nom d'un fichier à l'écran.
     *
     * @return le nom du fichier entré par l'utilisateur.
     */
    private static String demanderNomFichier() {
        String nom;

        System.out.println("Veuillez entrer le nom de votre fichier :");
        Scanner clavier = new Scanner(System.in);
        nom = clavier.nextLine();
        clavier.close();
        return nom;
    }
}
