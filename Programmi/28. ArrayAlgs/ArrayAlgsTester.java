public class ArrayAlgsTester {
    public static void main(String[] args) {
        int[] array = { 1, 5, 6, 8, 9, 34, 55, 66, 77, 99, 101, 245, 494 };

        int positionOfNine = ArrayAlgs.binarySearch(array, array.length, 9);
        System.out.println(positionOfNine);
    }
}
