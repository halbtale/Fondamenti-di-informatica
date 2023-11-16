/**
 * Simulatore di una cassa
 */
public class CashRegister {
    private double purchase;
    private double payment;

    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.1;
    public static final double NICKEL_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;

    public CashRegister() {
        purchase = 0;
        payment = 0;
    }

    /**
     * Registra la vendita di un articolo
     * 
     * @param amount il prezzo dell'articolo
     */
    public void recordPurchase(double amount) {
        purchase += amount;
    }

    /**
     * Registra importo pagato dall'utente
     * 
     * @param amount soldi versati dal cliente
     */
    public void enterPayment(double amount) {
        payment = amount;
    }

    /**
     * Registra importo pagato dall'utente
     * 
     * @param dollars
     * @param quarters
     * @param dimes
     * @param nickels
     * @param pennies
     */
    public void enterPayment(int dollars, int quarters, int dimes, int nickels, int pennies) {
        payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE
                + pennies * PENNY_VALUE;
    }

    /**
     * Calcola il resto e azzera la macchina per la vendita successiva
     * 
     * @return resto dovuto al cliente
     */
    public double giveChange() {
        double change = payment - purchase;
        payment = 0;
        purchase = 0;
        return change;
    }

}
