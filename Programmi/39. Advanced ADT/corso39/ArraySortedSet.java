@SuppressWarnings("unchecked")
public class ArraySortedSet implements SortedSet { 
    private Comparable[] array; 
    private int arraySize; 
    private static int INIT_SIZE = 100; 
    
    public ArraySortedSet() {
        array = new Comparable[INIT_SIZE];
    }

    public boolean isEmpty() {
        return arraySize == 0;
    }

    public void makeEmpty() {
        arraySize = 0;
    }

    public void add(Object obj) {
        throw new ClassCastException();
    }

    public void add(Comparable obj) {
        if (contains(obj)) return;
        if (array.length == arraySize) doubleArraySize();
        array[arraySize++] = obj;
        insertionSort();
    }

    public boolean contains(Object obj) {
        throw new ClassCastException();
    }

    public boolean contains(Comparable obj) {
        int objIndex = binarySearchFindPos(0, arraySize - 1, obj);
        return objIndex != -1;
    }

    public Object[] toArray() {
        throw new ClassCastException();
    }

    public Comparable[] toSortedArray() {
        Comparable[] newArray = new Comparable[arraySize];

        System.arraycopy(array, 0, newArray, 0, arraySize);
        return newArray;
    }

    private int binarySearchFindPos(int startIndex, int endIndex, Comparable searchValue) {
        if (startIndex > endIndex) return -1;
        int midIndex = (startIndex + endIndex) / 2;
        if (array[midIndex].compareTo(searchValue) == 0) {
            return midIndex;
        } else if (searchValue.compareTo(array[midIndex]) > 0) {
            return binarySearchFindPos(midIndex + 1, endIndex, searchValue);
        } else {
            return binarySearchFindPos(startIndex, midIndex - 1, searchValue);
        }
    }

    private void doubleArraySize() {
        Comparable[] newArray = new Comparable[arraySize * 2];
        System.arraycopy(array, 0, newArray, 0, arraySize);
        array = newArray;
    }

    private void insertionSort() {
        if (arraySize < 2) return;
        for (int i = 1; i<arraySize; i++) {
            Comparable currentElement = array[i];
            
            int j;

            for (j = i; j > 0 && currentElement.compareTo(array[j - 1]) < 0; j--) {
                array[j] = array[j-1];
            }

            array[j] = currentElement;
        }
    }

    public String toString() {
        String s = "[";
        int i;
        for (i = 0; i<arraySize; i++) {
            s += array[i] + ", ";
        }
        if (i > 0) s += "\b\b";
        s += "]";

        return s;
    }

    public static SortedSet union(SortedSet s1, SortedSet s2) {
        SortedSet newSet = new ArraySortedSet();
        Comparable[] array1 = s1.toSortedArray();
        Comparable[] array2 = s2.toSortedArray();

        int i=0, i1 = 0, i2 = 0;
        while (i1 < array1.length && i2 < array2.length) {
            if (array1[i1].compareTo(array2[i2]) < 0) {
                newSet.add(array1[i1++]);
            } else if (array2[i2].compareTo(array1[i1]) < 0) {
                newSet.add(array2[i2++]);
            } else {
                newSet.add(array1[i1]);
                i1++;
                i2++;
            }
        }

        return newSet;
    }

    public static SortedSet intersection(SortedSet s1, SortedSet s2) {
        SortedSet newSet = new ArraySortedSet();
        Comparable[] array1 = s1.toSortedArray();

        for (int i = 0; i<array1.length; i++) {
            if (s2.contains(array1[i])) {
                newSet.add(array1[i]);
            }
        }

        return newSet;
    }

    public static SortedSet subtract(SortedSet s1, SortedSet s2) {
                SortedSet newSet = new ArraySortedSet();
        Comparable[] array1 = s1.toSortedArray();

        for (int i = 0; i<array1.length; i++) {
            if (!s2.contains(array1[i])) {
                newSet.add(array1[i]);
            }
        }

        return newSet;
    }
}