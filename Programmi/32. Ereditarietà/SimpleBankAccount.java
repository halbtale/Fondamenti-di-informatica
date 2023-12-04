public class SimpleBankAccount {
    private double balance;

    public SimpleBankAccount() {
        balance = 0;
    }

    public SimpleBankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(double amount, SimpleBankAccount otherAccount) {
        withdraw(amount);
        otherAccount.deposit(amount);
    }
}
