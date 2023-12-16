public class ArrayAlgorithms {
    @SuppressWarnings("unchecked")
    public static <T> T[] resizeArray(T[] oldArray, int newLength) {
        if (oldArray == null || newLength < 0)
            throw new IllegalArgumentException();

        T[] newArray = (T[]) new Comparable[newLength];

        for (int i = 0; i < Math.min(newArray.length, oldArray.length); i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    public static <T> void remove(T[] array, int arraySize, int index) {
        array[index] = array[arraySize - 1];
    }

    public static <T> void removeSorted(T[] array, int arraySize, int index) {
        for (int i = index; i < arraySize; i++) {
            array[i] = array[i + 1];
        }
    }

    public static <T> T[] insert(T[] array, int arraySize, int index, T value) {
        if (array == null || arraySize < 0 || index > arraySize)
            throw new IllegalArgumentException();

        if (array.length == arraySize)
            array = resizeArray(array, arraySize * 2);

        for (int i = arraySize; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = value;

        return array;
    }

    public static <T extends Comparable<T>> int findMinPosition(T[] array, int startIndex, int endIndex) {
        T minElement = array[0];
        int minPosition = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i].compareTo(minElement) < 0) {
                minElement = array[i];
                minPosition = i;
            }
        }

        return minPosition;
    }

    public static <T extends Comparable<T>> int findMaxPosition(T[] array, int startIndex, int endIndex) {
        T maxElement = array[0];
        int maxPosition = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i].compareTo(maxElement) > 0) {
                maxElement = array[i];
                maxPosition = i;
            }
        }

        return maxPosition;
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array, int arraySize) {
        for (int i = 0; i < arraySize; i++) {
            int minElementIndex = findMinPosition(array, i, arraySize - 1);
            if (minElementIndex != i)
                swap(array, i, minElementIndex);
        }
    }

    private static <T> void swap(T[] array, int indexElement1, int indexElement2) {
        T element1 = array[indexElement1];
        T element2 = array[indexElement2];
        array[indexElement1] = element2;
        array[indexElement2] = element1;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void mergeSort(T[] array, int arraySize) {
        if (arraySize < 2)
            return;

        int midPosition = arraySize / 2;

        T[] arrayLeftPart = (T[]) new Comparable[midPosition];
        T[] arrayRightPart = (T[]) new Comparable[arraySize - midPosition];

        System.arraycopy(array, 0, arrayLeftPart, 0, arrayLeftPart.length);
        System.arraycopy(array, midPosition, arrayRightPart, 0, arrayRightPart.length);

        mergeSort(arrayRightPart, arrayRightPart.length);
        mergeSort(arrayLeftPart, arrayLeftPart.length);

        merge(array, arrayLeftPart, arrayRightPart);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] arrayLeftPart, T[] arrayRightPart) {
        int iFull = 0, iLeft = 0, iRight = 0;

        while (iLeft < arrayLeftPart.length && iRight < arrayRightPart.length) {
            if (arrayLeftPart[iLeft].compareTo(arrayRightPart[iRight]) < 0) {
                array[iFull++] = arrayLeftPart[iLeft++];
            } else {
                array[iFull++] = arrayRightPart[iRight++];
            }
        }

        while (iLeft < arrayLeftPart.length) {
            array[iFull++] = arrayLeftPart[iLeft++];
        }

        while (iRight < arrayRightPart.length) {
            array[iFull++] = arrayRightPart[iRight++];
        }
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array, int arraySize) {
        for (int i = 1; i < arraySize; i++) {
            T currentElement = array[i];

            int j;

            for (j = i; j > 0 && currentElement.compareTo(array[j]) < 0; j--) {
                array[j] = array[j - 1];
            }

            array[j] = currentElement;
        }
    }

    public static <T> int linearSearch(T[] array, int arraySize, T searchValue) {
        for (int i = 0; i < arraySize; i++) {
            if (array[i].equals(searchValue))
                return i;
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, int arraySize, T searchValue) {
        return recursiveBinarySearch(array, 0, arraySize - 1, searchValue);
    }

    private static <T extends Comparable<T>> int recursiveBinarySearch(T[] array, int startIndex, int endIndex,
            T searchValue) {
        if (startIndex > endIndex)
            return -1;
        int midIndex = (endIndex + startIndex) / 2;
        T midElement = array[midIndex];

        if (midElement.equals(searchValue)) {
            return midIndex;
        } else if (midElement.compareTo(searchValue) < 0) {
            return recursiveBinarySearch(array, midIndex + 1, endIndex, searchValue);
        } else {
            return recursiveBinarySearch(array, startIndex, midIndex - 1, searchValue);
        }

    }
}