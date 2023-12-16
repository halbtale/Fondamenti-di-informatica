import java.util.Arrays;

public class ArrayAlgorithmsTester {
    public static void main(String[] args) {
        String[] array = { "Hello", "World", "Hi" };

        array = ArrayAlgorithms.resizeArray(array, 10);
        array = ArrayAlgorithms.insert(array, array.length, 10, "OK");

        System.out.println(Arrays.toString(array));
    }
}
