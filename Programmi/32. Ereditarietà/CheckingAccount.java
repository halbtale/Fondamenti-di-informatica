public class CheckingAccount extends SimpleBankAccount {
    private int transactionCount;
    private static final int FREE_TRANSACTIONS = 3;
    private static final double TRANSACTION_FEE = 2.0;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
        transactionCount = 0;
    }

    public void deposit(double amount) {
        super.deposit(amount);
        transactionCount++;
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
        transactionCount++;
    }

    public void deductFees() {
        if (transactionCount > FREE_TRANSACTIONS) {
            double fees = TRANSACTION_FEE * (transactionCount - FREE_TRANSACTIONS);
            super.withdraw(fees);
        }
        transactionCount = 0;
    }
}
