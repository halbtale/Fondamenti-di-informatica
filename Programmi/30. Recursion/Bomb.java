public class Bomb {
    public static void main(String[] args) {
        System.out.println("CALCOLO.. intanto studia Analisi");
        long result = recursiveFib(31);
        System.out.println(result);
    }

    public static long recursiveFib(int n) {
        if (n < 1)
            throw new IllegalArgumentException();
        long f;
        if (n < 3)
            f = 1;
        else
            f = recursiveFib(n - 1) + recursiveFib(n - 2);

        return f;
    }
}