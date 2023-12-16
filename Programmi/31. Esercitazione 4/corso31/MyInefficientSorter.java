package corso31;

import java.util.Arrays;
import java.util.Scanner;

public class MyInefficientSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[10];
        int numbersSize = 0;

        while (scanner.hasNext()) {
            if (numbersSize >= numbers.length) {
                numbers = resizeArray(numbers, numbersSize * 2);
            }

            numbers[numbersSize++] = scanner.nextInt();
        }
        scanner.close();

        numbers = resizeArray(numbers, numbersSize);
        int[] orderedNumbers = new int[numbersSize];
        int orderedNumbersSize = 0;

        while (numbers.length > 0) {
            int minIndex = findMinIndex(numbers);
            orderedNumbers[orderedNumbersSize++] = numbers[minIndex];
            numbers = deleteAndResizeArray(numbers, minIndex);
        }

        System.out.println(Arrays.toString(orderedNumbers));
    }

    private static int[] deleteAndResizeArray(int[] oldArray, int indexOfElementToDelete) {
        oldArray[indexOfElementToDelete] = oldArray[oldArray.length - 1];
        return resizeArray(oldArray, oldArray.length - 1);
    }

    private static int findMinIndex(int[] numbers) {
        int min = numbers[0];
        int minIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static int[] resizeArray(int[] oldArray, int newSize) {
        if (oldArray == null || newSize < 0)
            throw new IllegalArgumentException();

        int[] newArray = new int[newSize];

        for (int i = 0; i < Math.min(newArray.length, oldArray.length); i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }
}
