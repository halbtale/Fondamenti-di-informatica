public class InsertionSortRecursive {
    public static void insertionSortRi(int[] a, int n) {
        if (n > 1) {
            insertionSortRi(a, n-1);
            int value = a[n-1];
            int i;

            for (int i = n-2; i >= 0 && a[i] > value; i--) {
                a[i+1] = a[i];
            }
            a[i+1] = value;
        }
    }
}