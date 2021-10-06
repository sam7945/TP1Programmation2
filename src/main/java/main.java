

public class main {
    private static Original original = Original.InstanceOriginal();
    private static Nouveau nouveau = Nouveau.instanceNouveau();

    public static void main(String[] args) {
        File.readFile();
        affichage();
    }

    public static void affichage() {
        for (int i = 0; i < nouveau.getCoordonnees().size(); i++) {
            System.out.println(nouveau.getCoordonnees().get(i).getY());
        }
    }
}
