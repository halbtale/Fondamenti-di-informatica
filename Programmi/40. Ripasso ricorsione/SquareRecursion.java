public class SquareRecursion {
    public static int square(int n, int k) {
        if (k < 0) throw new IllegalArgumentException();

        if (k == 0) return 0;

        return ( square(n-1) + 2*n - 1 )
    }
}