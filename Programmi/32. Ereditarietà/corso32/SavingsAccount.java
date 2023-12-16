
public class SavingsAccount extends SimpleBankAccount {
    private double interestRate;
    private final double FEE = 2.58;

    public SavingsAccount(double rate) {
        interestRate = rate;
    }

    public SavingsAccount(double initialBalance, double rate) {
        super(initialBalance);
        interestRate = rate;
    }

    public void addInterest() {
        deposit(getBalance() * interestRate / 100);
    }

    public void deposit(double amount) {
        super.deposit(amount);
        withdraw(FEE);
    }

    public String toString() {
        return super.toString() + "[interestRate=" + interestRate + "]";
    }
}
