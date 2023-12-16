package corso22;

import java.util.Scanner;

public class PrimeNumberRecognizer {
    public static void main(String[] args) {
        int n = 0;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Inserisci un numero!");
            n = in.nextInt();
        } while (n <= 0);
        int j = n;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                j = i;
                break;
            }
        }

        if (j == n) {
            System.out.printf("il numero %d è primo%n", n);
        } else {
            System.out.printf("il numeo %d e' divisibile per %d%n", n, j);
        }

    }
}
