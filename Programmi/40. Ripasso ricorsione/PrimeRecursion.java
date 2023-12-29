public class PrimeRecursion {
    public static boolean isPrimo(int n) {
        if (n < 2) throw new IllegalArgumentException();

        return (primoRi, 2);
    }

    public static boolean primoRi(int n, int k) {
        if (k*k > n) return true;
        if (n%k == 0) return false;
        return primoRi(n, k+1);
    }
}