package corso28;

public class ArrayAlgs {
    public static int[] resize(int[] oldArray, int newLength) {
        if (newLength < 0 || oldArray == null)
            throw new IllegalArgumentException();

        int[] newArray = new int[newLength];
        int n = Math.min(oldArray.length, newLength);

        for (int i = 0; i < n; i++)
            newArray[i] = oldArray[i];

        return newArray;
    }

    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (n * Math.random());
        return a;
    }

    public static String printArray(int[] v, int vSize) {
        String s = "[";
        for (int i = 0; i < vSize; i++)
            s = s + v[i] + " ";

        s = s + "\b]";

        return s;
    }

    public static void remove(int[] v, int vSize, int index) {
        v[index] = v[vSize - 1];
    }

    public static void removeSorted(int[] v, int vSize, int index) {
        for (int i = index; i < vSize - 1; i++)
            v[i] = v[i + 1];
    }

    public static int[] insert(int[] v, int vSize, int index, int val) {
        if (vSize == v.length)
            v = resize(v, 2 * v.length);

        for (int i = vSize; i > index; i--)
            v[i] = v[i - 1];

        v[index] = val;
        return v;
    }

    public static int findMin(int[] v, int vSize) {
        int min = v[0];

        for (int i = 1; i < vSize; i++)
            if (v[i] < min)
                min = v[i];

        return min;
    }

    public static int findMax(int[] v, int vSize) {
        int max = v[0];

        for (int i = 1; i < vSize; i++)
            if (v[i] > max)
                max = v[i];

        return max;
    }

    public static void selectionSort(int[] v, int vSize) {
        for (int i = 0; i < vSize - 1 /* ultimo indice */; i++) {
            int minPos = findMinPos(v, i, vSize - 1 /* non serve riordinare ultimo elemento */);
            if (minPos != i)
                swap(v, minPos, i);
        }
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    };

    private static int findMinPos(int[] v, int from, int to) { // non cerco su tutto array ma solo su parte di interesse
        int pos = from;
        int min = v[from];
        for (int i = from + 1; i <= to; i++) {
            if (v[i] < min) {
                pos = i;
                min = v[i];
            }
        }
        return pos;
    }

    public static void mergeSort(int[] arrayFull, int arraySize) {
        if (arraySize < 2)
            return;

        int midPosition = arraySize / 2;

        int[] arrayLeftPart = new int[midPosition];
        int[] arrayRightPart = new int[arraySize - midPosition];

        System.arraycopy(arrayFull, 0, arrayLeftPart, 0, arrayLeftPart.length);
        System.arraycopy(arrayFull, midPosition, arrayRightPart, 0, arrayRightPart.length);

        mergeSort(arrayLeftPart, arrayLeftPart.length);
        mergeSort(arrayRightPart, arrayRightPart.length);

        merge(arrayFull, arrayLeftPart, arrayRightPart);
    }

    private static void merge(int[] arrayFull, int[] arrayLeftPart, int[] arrayRightPart) {
        int arrayFullIndex = 0, arrayLeftPartIndex = 0, arrayRightPartIndex = 0;
        while (arrayLeftPartIndex < arrayLeftPart.length && arrayRightPartIndex < arrayRightPart.length) {
            if (arrayLeftPart[arrayLeftPartIndex] < arrayRightPart[arrayRightPartIndex]) {
                arrayFull[arrayFullIndex] = arrayLeftPart[arrayLeftPartIndex];
                arrayFullIndex++;
                arrayLeftPartIndex++;
            } else {
                arrayFull[arrayFullIndex] = arrayRightPart[arrayRightPartIndex];
                arrayFullIndex++;
                arrayRightPartIndex++;
            }
        }

        while (arrayLeftPartIndex < arrayLeftPart.length) {
            arrayFull[arrayFullIndex] = arrayLeftPart[arrayLeftPartIndex];
            arrayFullIndex++;
            arrayLeftPartIndex++;
        }

        while (arrayRightPartIndex < arrayRightPart.length) {
            arrayFull[arrayFullIndex] = arrayRightPart[arrayRightPartIndex];
            arrayFullIndex++;
            arrayRightPartIndex++;
        }
    }

    public static void insertionSort(int[] arrayFull, int arraySize) {
        // il ciclo inizia da 1 perché il primo elemento non richiede attenzione

        for (int i = 1; i < arraySize; i++) {
            int newElementToAdd = arrayFull[i];

            int j; // definisco fuori perché dopo devo utilizzarlo

            for (j = i; j > 0 && arrayFull[j - 1] > newElementToAdd; j--) {
                // sposto a destra ogni elemento maggiore di newElementToAdd
                arrayFull[j] = arrayFull[j - 1];
            }

            // inserisco nella posizione lasciata libera newElementToAdd
            arrayFull[j] = newElementToAdd;
        }
    }

    public static int linearSearch(int[] array, int arraySize, int searchValue) {
        for (int i = 0; i < arraySize; i++)
            if (array[i] == searchValue)
                return i; // trovato valore

        return -1; // valore non trovato
    }

    public static int binarySearch(int[] array, int arraySize, int searchValue) {
        return recursiveBinarySearch(array, 0, arraySize - 1, searchValue);
    }

    private static int recursiveBinarySearch(int[] array, int startIndex, int endIndex, int searchValue) {
        if (startIndex > endIndex)
            return -1; // elemento non trovato
        int midIndex = (startIndex + endIndex) / 2;
        int midElement = array[midIndex];

        if (midElement == searchValue) {
            return midIndex;
        } else if (midElement < searchValue) {
            // cerca a destra
            return recursiveBinarySearch(array, midIndex + 1, endIndex, searchValue);
        } else {
            // cerca a sinistra
            return recursiveBinarySearch(array, 0, midIndex - 1, searchValue);
        }
    }
}
