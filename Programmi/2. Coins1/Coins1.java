/**
 * Lo scopo del programma è di sommare monete di valute diverse e restituire il
 * valore totale in euro
 */
public class Coins1 {
    public static void main(String[] args) {
        int lit = 15000; // lire italiane
        double euro = 2.35; // euro
        double dollars = 3.05;
        double fattoreDiConversione = 1926.27;

        // calcola il valore totale
        double totalEuro = euro + lit / fattoreDiConversione;

        totalEuro = totalEuro + euro;
        totalEuro = totalEuro + dollars * 0.72;

        System.out.print("Valore totale in euro ");
        System.out.println(totalEuro);
    }
}

/**
 * Tipologie di variabili:
 * int -> numero intero
 * double -> numero decimale
 * String -> stringa
 */