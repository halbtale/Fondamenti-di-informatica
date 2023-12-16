
public class Bomb {
    public static void main(String[] args) {
        System.out.println("CALCOLO.. intanto studia Analisi");
        long initialTime = System.currentTimeMillis();
        long result = recursiveFib(41);
        long duration = System.currentTimeMillis() - initialTime;
        System.out.println(result);
        System.out.println("TIME in ms: " + duration);
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