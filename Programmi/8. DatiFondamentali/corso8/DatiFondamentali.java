package corso8;

import java.math.*;

public class DatiFondamentali {
    public static void main(String[] args) {
        // final -> costante
        final double AMOUNT = 1.0e+17;
        final int DISCOUNT = 49;

        System.out.println("AMOUNT in double = " + AMOUNT);
        double doubleResult = AMOUNT - DISCOUNT;
        long incorrectLongResult = (long) (AMOUNT - DISCOUNT);
        long longResult = (long) AMOUNT - DISCOUNT;

        System.out.println("Result = " + doubleResult);
        System.out.println("Result = " + incorrectLongResult);
        System.out.println("Result = " + longResult);
    }
}
