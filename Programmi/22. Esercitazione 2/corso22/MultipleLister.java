package corso22;

import java.util.Scanner;

public class MultipleLister {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci il numero massimo");
        int max = in.nextInt();

        int n = 0;
        do {
            System.out.println("Inserisci un numero intero positivo minore di " + max);
            n = in.nextInt();
        } while (n <= 0 || n > max);

        String risultato = "multipli di " + n + " da 1 a " + max + ": ";

        for (int i = n; i < max; i = i + n) {
            risultato += i + " ";
        }

        System.out.println(risultato);

        in.close();
    }
}
