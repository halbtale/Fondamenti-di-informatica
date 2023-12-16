package corso32;

public class AccountTester {
    public static void main(String[] args) {
        SavingsAccount account1 = new SavingsAccount(10);

        SimpleBankAccount account2 = new SimpleBankAccount();

        account1.transfer(10, account2);

        // bAccount.addInterest(); -> errore
    }
}
