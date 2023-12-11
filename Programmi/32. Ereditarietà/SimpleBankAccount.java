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

    public String toString() {
        return getClass().getName() + "[balance=" + balance + "]";
    }

    public boolean equals(Object otherObject) {
        BankAccount otherAccount = (BankAccount) otherObject;
        return balance == otherAccount.balance;
    }

    public int compareTo(Object object) {
        BankAccount otherBankAccount = (BankAccount) object;
        if (balance < otherBankAccount.balance)
            return -1;
        if (balance > otherBankAccount.balance)
            return 1;
        return 0;
    }
}
