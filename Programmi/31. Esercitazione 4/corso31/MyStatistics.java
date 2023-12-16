
import java.util.Arrays;
import java.util.Scanner;

public class MyStatistics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int DEFAULT_ARRAY_SIZE = 10;

        int[] numbers = new int[DEFAULT_ARRAY_SIZE];
        int numbersSize = 0;

        while (in.hasNext()) {
            int number = in.nextInt();
            if (numbersSize >= numbers.length) {
                numbers = resizeArray(numbers, numbersSize * 2);
            }
            numbers[numbersSize++] = number;
        }

        double average = getAverage(numbers, numbersSize);
        double standardDeviation = getStandardDeviation(numbers, numbersSize, average);

        System.out.println("The average is: " + average);
        System.out.println("The standard deviation is: " + standardDeviation);

        in.close();

    }

    private static double getAverage(int[] numbers, int numbersSize) {
        int sum = 0;
        for (int i = 0; i < numbersSize; i++) {
            sum += numbers[i];
        }
        return sum / numbersSize;
    }

    private static double getStandardDeviation(int[] numbers, int numbersSize, double numbersAverage) {
        int standardDeviationNumerator = 0;

        for (int i = 0; i < numbersSize; i++) {
            standardDeviationNumerator += Math.pow(numbers[i] - numbersAverage, 2);
        }

        double standardDeviation = Math.sqrt(standardDeviationNumerator / numbersSize);

        return standardDeviation;
    }

    private static int[] resizeArray(int[] oldArray, int newSize) {
        if (newSize < 0 || oldArray == null)
            throw new IllegalArgumentException();

        int[] newArray = new int[newSize];

        for (int i = 0; i < Math.min(newArray.length, oldArray.length); i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }
}
