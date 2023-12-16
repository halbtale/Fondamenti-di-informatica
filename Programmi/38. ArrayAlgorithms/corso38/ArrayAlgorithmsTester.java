import java.util.Arrays;

public class ArrayAlgorithmsTester {
    public static void main(String[] args) {
        String[] array = { "Hello", "World", "A", "B", "Z", "C" };

        ArrayAlgorithms.insertionSort(array, array.length);

        System.out.println(Arrays.toString(array));

        int index = ArrayAlgorithms.binarySearch(array, array.length, "B");
        System.out.println(index);
    }
}
