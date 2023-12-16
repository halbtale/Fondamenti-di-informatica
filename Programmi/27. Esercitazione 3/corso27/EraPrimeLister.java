package corso27;

import java.util.Scanner;

public class EraPrimeLister {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci n naturale: ");
        int n = in.nextInt();

        if (n < 1) {
            System.out.println("Numero inserito non valido");
            System.exit(1);
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 2) {
                for (int j = 0; j < numbers.length; j++) {
                    if (numbers[j] % numbers[i] == 0 && numbers[j] != numbers[i]) {
                        numbers[j] = 0;
                    }
                }
            }
        }

        String result = "numeri primi nell'intervallo [1," + n + "]: ";

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                result += i + " ";
            }
        }

        System.out.println(result);

        in.close();
    }
}