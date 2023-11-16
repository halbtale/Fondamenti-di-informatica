public class Conversioni {
    public static void main(String[] args) {
        double votoApprossimato = 17.999999999;
        // int intVar = doubleVar; // dà errore
        // int votoFinale = (int) votoApprossimato;
        int votoFinale = (int) Math.round(votoApprossimato);

        if (votoFinale >= 18) {
            System.out.println("Promosso");
        } else {
            System.out.println("Bocciato");
        }
        System.out.println(votoFinale);
    }
}
