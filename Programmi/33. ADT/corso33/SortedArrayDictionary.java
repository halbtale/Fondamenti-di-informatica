
public class SortedArrayDictionary implements Dictionary {
    protected Pair[] array;
    protected int arraySize;
    protected final int INIT_SIZE = 100;

    SortedArrayDictionary() {
        array = new Pair[INIT_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return arraySize == 0;
    }

    public void makeEmpty() {
        arraySize = 0;
    }

    public void insert(Comparable key, Object value) {
        if (key == null)
            throw new IllegalArgumentException();

        try {
            remove(key);
        } catch (DictionaryItemNotFoundException e) {
        }

        if (arraySize == array.length)
            array = ArrayAlgorithms.resizeArray(array, arraySize * 2);

        array[arraySize++] = new Pair(key, value);

        ArrayAlgorithms.insertionSort(array, arraySize);
    }

    public void remove(Comparable key) {
        array[binarySearch(key)] = array[--arraySize];

        ArrayAlgorithms.insertionSort(array, arraySize);
    }

    public Object find(Comparable key) {
        return array[binarySearch(key)].getValue();
    }

    private int binarySearch(Comparable key) {
        int index = ArrayAlgorithms.binarySearch(array, arraySize, new Pair(key, null));
        if (index == -1)
            throw new DictionaryItemNotFoundException();
        return index;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < arraySize; i++) {
            s = s + array[i] + "\n";
        }
        return s;
    }

    protected class Pair implements Comparable {
        public Pair(Comparable key, Object value) {
            setKey(key);
            setValue(value);
        }
        // metodi pubblici

        public String toString() {
            return key + " " + value;
        }

        public Comparable getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public void setKey(Comparable key) {
            this.key = key;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public int compareTo(Object obj) {
            if (obj instanceof Pair) {
                Pair otherPair = (Pair) obj;
                return this.key.compareTo(otherPair.key);
            } else {
                throw new IllegalArgumentException();
            }
        }

        // campi di esemplare
        private Comparable key;
        private Object value;

    }

}
