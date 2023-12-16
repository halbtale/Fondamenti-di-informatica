
public class ArrayDictionary implements Dictionary {
    protected Pair[] array;
    protected int arraySize;
    protected final int INIT_SIZE = 100;

    public ArrayDictionary() {
        array = new Pair[INIT_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return arraySize == 0;
    }

    public void makeEmpty() {
        arraySize = 0;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < arraySize; i++) {
            s = s + array[i] + "\n";
        }
        return s;
    }

    public void insert(Comparable key, Object value) {
        if (key == null)
            throw new IllegalArgumentException();
        try {
            remove(key);
        } catch (DictionaryItemNotFoundException e) {
        }

        if (arraySize == array.length)
            array = resize(2 * arraySize);
        array[arraySize++] = new Pair(key, value);
    }

    protected Pair[] resize(int newLength) // solita tecnica
    {
        if (newLength < array.length)
            throw new IllegalArgumentException();
        Pair[] newArray = new Pair[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public void remove(Comparable key) {
        array[linearSearch(key)] = array[--arraySize];
    }

    public Object find(Comparable key) {
        return array[linearSearch(key)].getValue();
    }

    private int linearSearch(Comparable key) {
        for (int i = 0; i < arraySize; i++) {
            if (array[i].getKey().compareTo(key) == 0) {
                return i;
            }
        }
        throw new DictionaryItemNotFoundException();
    }

    protected class Pair // classe interna ad ArrayDictionary
    {
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

        // campi di esemplare
        private Comparable key;
        private Object value;

    }

}
