@SuppressWarnings({ "rawtypes", "unchecked" })
class Rubrica implements Dictionary {
    private static final int INIT_SIZE = 5;
    private Pair[] array;
    private int arraySize;

    public Rubrica() {
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
        if (key == null || value == null || !(value instanceof Long))
            throw new IllegalArgumentException();
        try {
            remove(key);
        } catch (DictionaryItemNotFoundException e) {
        }
        ;

        if (arraySize == array.length)
            resize(arraySize * 2);
        Pair newElement = new Pair((String) key, (long) value);

        arraySize++;

        int i;

        for (i = arraySize - 1; i > 0 && key.compareTo(array[i - 1].getName()) < 0; i--) {
            array[i] = array[i - 1];
        }

        array[i] = newElement;
    }

    public void remove(Comparable key) {
        int index = binSearch(key, 0, arraySize - 1);

        arraySize--;

        for (int i = index; i < arraySize; i++) {
            array[i] = array[i + 1];
        }
    }

    public Object find(Comparable key) {
        int index = binSearch(key, 0, arraySize - 1);
        return array[index].getPhone();
    }

    private int binSearch(Comparable key, int from, int to) {
        if (from > to)
            throw new DictionaryItemNotFoundException();
        int mid = (from + to) / 2;
        Pair midElement = array[mid];
        if (key.compareTo(midElement.getName()) == 0) {
            return mid;
        } else if (key.compareTo(midElement.getName()) < 0) {
            return binSearch(key, from, mid - 1);
        } else {
            return binSearch(key, mid + 1, to);
        }
    }

    private void resize(int newLength) {
        if (newLength < 0)
            throw new IllegalArgumentException();

        Pair[] resizedArray = new Pair[newLength];
        System.arraycopy(array, 0, resizedArray, 0, Math.min(newLength, array.length));
        array = resizedArray;
    }

    private class Pair {
        public Pair(String aName, long aPhone) {
            name = aName;
            phone = aPhone;
        }

        public String getName() {
            return name;
        }

        public long getPhone() {
            return phone;
        }

        /*
         * Restituisce una stringa contenente
         * - la nome, "name"
         * - un carattere di separazione ( : )
         * - il numero telefonico, "phone"
         */
        public String toString() {
            return name + " : " + phone;
        }

        // campi di esemplare
        private String name;
        private long phone;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < arraySize; i++) {
            output += array[i] + "\n";
        }
        return output;
    }
}