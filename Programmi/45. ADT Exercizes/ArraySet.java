@SuppressWarnings("unchecked")
class ArraySet implements SortedSet {
    private static final int INIT_ARRAY_SIZE = 5;
    private Comparable[] array;
    private int arraySize;

    public ArraySet() {
        array = new Comparable[INIT_ARRAY_SIZE];
        makeEmpty();
    }

    public void makeEmpty() {
        arraySize = 0;
    }

    public boolean isEmpty() {
        return arraySize == 0;
    }

    private int linearSearch(Comparable searchValue, int start, int end) {
        if (start > end) return -1;
        int mid = (start+end)/2;
        if (array[mid].compareTo(searchValue) == 0) {
            return mid;
        } else if (searchValue.compareTo(array[mid]) < 0) {
            return linearSearch(searchValue, start, mid - 1);
        } else {
            return linearSearch(searchValue, mid+1, end);
        }
    }

    public boolean contains(Object obj) {
        throw new IllegalArgumentException();
    }

    public boolean contains(Comparable searchValue) {
        int i = linearSearch(searchValue, 0, arraySize - 1);
        if (i == -1) return false;
        return true;
    }

    public void add(Object obj) {
        throw new IllegalArgumentException();
    }

    public void add(Comparable obj) {
        if (arraySize + 1 == array.length) array = resize(arraySize * 2);
        if (!contains(obj)) {
            arraySize++;
            int i;
            for (i = arraySize - 1; i > 0 && obj.compareTo(array[i - 1])< 0; i--) {
                array[i] = array[i - 1];
            }
            array[i] = obj;
        }
    }

    private Comparable[] resize(int newLength) {
        if (newLength < 0) throw new IllegalArgumentException();
        Comparable[] resizedArray = new Comparable[newLength];
        System.arraycopy(array, 0, resizedArray, 0, Math.min(newLength, array.length));
        return resizedArray;
    }

    public Object[] toArray() {
        return toSortedArray();
    }

    public Comparable[] toSortedArray() {
        return resize(arraySize);
    }

    public static SortedSet union(SortedSet s1, SortedSet s2) {
        SortedSet mergedSortedSet = new ArraySet();
        Comparable[] array1 = s1.toSortedArray();
        Comparable[] array2 = s2.toSortedArray();

        int i1 = 0;
        int i2 = 0;

        while (i1 < array1.length && i2 < array2.length) {
            if (array1[i1].compareTo(array2[i2]) < 0) {
                mergedSortedSet.add(array1[i1++]);
            } else {
                mergedSortedSet.add(array2[i2++]);
            }
        }

        while (i1 < array1.length) {
            mergedSortedSet.add(array1[i1++]);
        }

        while (i2 < array2.length) {
            mergedSortedSet.add(array2[i2++]);
        }

        return mergedSortedSet;
    }

    public static SortedSet intersection(SortedSet s1, SortedSet s2) {
        SortedSet mergedSortedSet = new ArraySet();

        Comparable[] array1 = s1.toSortedArray();

        for (int i = 0; i<array1.length; i++) {
            if (s2.contains(array1[i])) {
                mergedSortedSet.add(array1[i]);
            }
        }

        return mergedSortedSet;
    }

    public static SortedSet subtract(SortedSet s1, SortedSet s2) {
        SortedSet mergedSortedSet = new ArraySet();

        Comparable[] array1 = s1.toSortedArray();

        for (int i = 0; i<array1.length; i++) {
            if (!s2.contains(array1[i])) {
                mergedSortedSet.add(array1[i]);
            }
        }

        return mergedSortedSet;
    }

    public String toString() {
        String output = "";
        Comparable[] elements = toSortedArray();
        for (int i = 0; i<elements.length; i++) {
            output += elements[i] + "\n";
        }
        return output;
    }
}