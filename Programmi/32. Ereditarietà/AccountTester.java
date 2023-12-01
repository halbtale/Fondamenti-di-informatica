public class AccountTester {
    public static void main(String[] args) {
        SavingsAccount sAccount = new SavingsAccount(10);

        SimpleBankAccount bAccount = sAccount;
        Object oAccount = bAccount;

        // bAccount.addInterest(); -> errore
    }
}
