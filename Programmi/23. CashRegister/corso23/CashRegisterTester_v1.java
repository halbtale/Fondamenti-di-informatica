package corso23;

import java.util.Scanner;
import java.util.Locale;

public class CashRegisterTester_v1 {
    public static void main(String[] args) {
        CashRegister register = new CashRegister();
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        boolean done = false;

        while (!done) {
            System.out.println("Prezzo articolo (Q per uscire):");
            String input = in.next();
            if (input.equalsIgnoreCase("Q"))
                done = true;
            else {
                double amount = Double.parseDouble(input);
                register.recordPurchase(amount);
            }
        }

        System.out.println("Inserire pagamento");
        System.out.println("Dollars:");
        int dollars = in.nextInt();
        System.out.println("Quarters:");
        int quarters = in.nextInt();
        System.out.println("Dimes:");
        int dimes = in.nextInt();
        System.out.println("Nickels:");
        int nickels = in.nextInt();
        System.out.println("Pennies:");
        int pennies = in.nextInt();
        register.enterPayment(dollars, quarters, dimes, nickels, pennies);

        double change = register.giveChange();
        System.out.printf(Locale.US, "Resto dovuto: %.2f%n", change);
    }
}
