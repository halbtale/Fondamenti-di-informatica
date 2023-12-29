import java.util.Arrays;

public class InsertionSortRecursive {
    public static void insertionSortRi(int[] a, int n) {
        if (n > 1) {
            insertionSortRi(a, n-1); // riordina fino al penultimo elemento
            int value = a[n-1]; // prendi ultimo elemento
            int i;

            for (i = n-2; i >= 0 && a[i] > value; i--) { // fai un loop finché l'elemento a[i] > value
                a[i+1] = a[i]; // sposta a destra ogni elementi
            }
            a[i+1] = value; // sposta nello spazio lasciato vuoto l'ultimo elemento
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,6,15,2,5,2,66,23,33};
        insertionSortRi(array, array.length);
        Arrays.stream(array).forEach(System.out::println);
    }
}