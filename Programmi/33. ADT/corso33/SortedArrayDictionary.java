package corso33;

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
        if (key == null) throw new IllegalArgumentException();

        try {
            remove(key);
        } catch (DictionaryItemNotFoundException e) {}

        if (arraySize == array.length) array = ArrayAlgorithms.resizeArray(array, arraySize * 2);

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
        return ArrayAlgorithms.binarySearch(array, arraySize, new Pair(key, null));
    }

    protected class Pair
    {
        public Pair(Comparable key, Object value) {
            setKey(key);
            setValue(value);
        }
        // metodi pubblici

        public String toString() {
            return key + " " + value;
        }

        public boolean equals(otherPair Pair) {
            return this.key.equals(otherPair.key);
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

        public int compareTo(Pair otherPair) {
            return this.key.compareTo(otherPair.key);
        }

        // campi di esemplare
        private Comparable key;
        private Object value;

    }

}
