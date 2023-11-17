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
            int currentNumber = numbers[i];

        }

        in.close();
    }
}