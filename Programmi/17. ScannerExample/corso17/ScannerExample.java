package corso17;

import java.util.Scanner;
import java.util.Locale;

class ScannerExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.println("Inserisci nome cognome età");

        String firstName = in.next();
        String lastName = in.next();
        int age = in.nextInt();

        System.out.println("Quanti soldi hai?");

        double money = in.nextDouble();

        System.out.printf("Benvenuto %s %s! Hai %2d anni e %.2f€ %n", firstName, lastName, age, money);

        in.close();
    }
}