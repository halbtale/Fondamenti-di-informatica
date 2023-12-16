
import java.util.Scanner;

public class FactorResolver {
    public static void main(String[] args) {
        int inputNumber = 0;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Inserisci un numero!");
            inputNumber = in.nextInt();
        } while (inputNumber <= 1);
        String result = inputNumber + " = ";
        boolean isPrime = true;
        int numberToFactor = inputNumber;

        while (numberToFactor > 1) {
            for (int i = 2; i <= numberToFactor; i++) {
                if (numberToFactor % i == 0) {
                    if (numberToFactor == inputNumber) {
                        if (numberToFactor == i) {
                            result = result + "1 * " + i;
                        } else {
                            result = result + i;
                        }
                    } else {
                        result = result + " * " + i;
                    }
                    numberToFactor = numberToFactor / i;
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println(result);

        in.close();
    }
}
