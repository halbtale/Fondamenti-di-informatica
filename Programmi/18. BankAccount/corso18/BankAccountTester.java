package corso18;

import java.util.Scanner;

public class BankAccountTester {
    public static void main(String[] args) {
        final int INITIAL_BALANCE = 20000;
        final double RATE = 0.05;
        BankAccount account = new BankAccount(INITIAL_BALANCE);

        // Scanner in = new Scanner(System.in);

        // System.out.println("Benvenuto in banca!");
        // System.out.println("Ora hai " + INITIAL_BALANCE);

        // System.out.println("Quanti soldi vuoi ritirare?: ");
        // int amountToWithdraw = in.nextInt();

        // account.withdraw(amountToWithdraw);

        // System.out.println("Ora hai " + account.getBalance());

        // BankAccount account1 = new BankAccount(100);
        // BankAccount account2 = new BankAccount(100);

        // System.out.println(account1.equals(account2));

        int year = 0;

        while (account.getBalance() < 2 * INITIAL_BALANCE) {
            year++;
            double interest = account.getBalance() * RATE;
            account.deposit(interest);
        }

        System.out.println("Investimento raddoppia in " + year + " anni");
    }
}