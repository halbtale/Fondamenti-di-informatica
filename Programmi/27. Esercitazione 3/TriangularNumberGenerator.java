import java.util.Scanner;

public class TriangularNumberGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Quanti numeri triangolari vuoi: ");
            int k = in.nextInt();
            int n = 1;
            if (k <= 0)
                throw new IllegalArgumentException();

            for (int i = 2; i <= k; i++) {
                System.out.printf("T(%d) = %d + T(%d) = %d%n", i - 1, n, i - 2, n + i);
                n = n + i;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("k inserito non valido");
        } finally {
            in.close();
        }
    }
}
