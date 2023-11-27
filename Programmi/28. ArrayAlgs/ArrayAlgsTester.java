import java.util.Arrays;

public class ArrayAlgsTester {
    public static void main(String[] args) {
        int[] array = { 8, 7, 6, 5, 4, 3, 2, 1 };
        ArrayAlgs.mergeSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
