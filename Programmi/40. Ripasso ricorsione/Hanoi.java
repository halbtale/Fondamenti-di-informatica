public class Hanoi {
    public static void solveHanoi(int from, int to, int temp, int dim) {
        if (dim > 0) {
            solveHanoi(from, temp, to, dim-1);
            System.out.println("Sposta il disco "+ dim + " da T" + from + " a T"+to);
            solveHanoi(temp, to, from, dim-1);
        }
    }
}