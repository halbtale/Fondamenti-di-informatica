public class ArraySet implements Set {
    private Object[] array;
    private int arraySize;
    private static int INIT_SIZE = 10;

    public ArraySet() {
        array = new Object[INIT_SIZE];
        arraySize = 0;
    }

    public void makeEmpty() {
        arraySize = 0;
    };

    public boolean isEmpty() {
        return arraySize == 0;
    };

    public void add(Object x) {
        if (contains(x)) return;
        if (arraySize == array.length) array = resize(arraySize * 2);
        array[arraySize++] = x;
    }

    public boolean contains(Object x) {
        for (int i = 0; i<arraySize; i++) {
            if (array[i].equals(x)) return true;
        }
        return false;
    }

    public Object[] toArray() {
        Object[] x = new Object[arraySize];
        System.arraycopy(array, 0, x, 0, arraySize);
        return x;    
    }

    private Object[] resize(int newLength) {
        if (newLength < 0) throw new IllegalArgumentException();
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newArray.length));
        return newArray;
    }

    public static Set union(Set s1, Set s2) {
        Set mergedSet = new ArraySet();
        Object[] array1 = s1.toArray();
        Object[] array2 = s2.toArray();

        for (int i = 0; i<array1.length; i++) {
            mergedSet.add(array1[i]);
        }

        for (int i = 0; i<array2.length; i++) {
            mergedSet.add(array2[i]);
        }

        return mergedSet;
    }

    public static Set intersection(Set s1, Set s2) {
        Set mergedSet = new ArraySet();
        Object[] array1 = s1.toArray();

        for (int i = 0; i<array1.length; i++) {
            if (s2.contains(array1[i])) {
                mergedSet.add(array1[i]);
            }
        }
        return mergedSet;
    }

    public static Set subtract(Set s1, Set s2) {
        Set mergedSet = new ArraySet();
        Object[] array1 = s1.toArray();

        for (int i = 0; i<array1.length; i++) {
            if (!s2.contains(array1[i])) {
                mergedSet.add(array1[i]);
            }
        }
        return mergedSet;
    }
}