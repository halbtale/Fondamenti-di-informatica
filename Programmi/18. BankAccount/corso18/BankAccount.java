package corso18;

/**
 * Un conto bancario ha un saldo modificabile tramite depositi e prelievi
 */
public class BankAccount {
    private double balance;
    private final double OVERDRAFT_PENALITY = 1;
    private int accountNumber;
    private static int lastAssignedNumber = 0;

    public BankAccount() {
        balance = 0;
    }

    public BankAccount(double initialBalance) {
        lastAssignedNumber++;
        accountNumber = lastAssignedNumber;
        balance = initialBalance;
    }

    /**
     * Deposita denaro sul conto
     * 
     * @param amount importo da depositare
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Preleva denaro dal conto
     * 
     * @param amount importo da prelevare
     */
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Prelievo andato a buon fine");
        } else {
            balance -= OVERDRAFT_PENALITY;
            System.out.println("Hai provato a ritirare più soldi di quanti ne disponevi. Ora prendi una multa!");
        }
    }

    /**
     * Ispeziona saldo attuale
     * 
     * @return saldo attuale
     */
    public double getBalance() {
        return balance;
    }

    public boolean equals(BankAccount otherBankAccount) {
        return balance == otherBankAccount.balance;
    }
}
