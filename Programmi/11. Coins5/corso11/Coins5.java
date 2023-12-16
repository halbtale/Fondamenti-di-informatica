
public class Coins5 {
    public static void main(String[] args) {
        float euro = 2.35f;
        final int CENT_PER_EURO = 100;
        int totalCentEuro = Math.round(euro * CENT_PER_EURO);
        int intEuro = totalCentEuro / 100;
        int centEuro = totalCentEuro % CENT_PER_EURO;

        System.out.println(intEuro + " euro e " + centEuro + " centesimi");
    }
}
