import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class D implements Dictionary {
    private static final int ARRAY_INIT_SIZE = 2;
    private Pair[] array;
    private int arraySize;

    public D() {
        array = new Pair[ARRAY_INIT_SIZE];
        makeEmpty();
    }

    /** Restituisce true se il contenitore e' vuoto, false altrimenti. */
	public boolean isEmpty() {
        return arraySize == 0;
    }
	
	/** Rende vuoto il contenitore. */
	public void makeEmpty() {
        arraySize = 0;
    }
	
	/** Restituisce il numero di elementi inseriti nel contenitore. */
	public int size() {
        return arraySize;
    }

    /** Inserisce la coppia (key, attribute) nel dizionario. 
	* Se la chiave e' gia' presente sovrascrive la coppia. 
	*/
	public void insert(Comparable key, Object attribute) {
        if (arraySize == array.length) resize();

        Pair newPair = new Pair(key, attribute);

        try {
            remove(key);
        } catch (NoSuchElementException e) {}

        array[arraySize++] = newPair;
    }
	
	/** Restituisce l'attributo associato alla chiave key nel dizionario. 
	* Se la chiave non e' presente, genera l'eccezione java.util.NoSuchElementException
	*/
	public Object find(Comparable key) {
        return array[linearSearch(key)].getValue();
    }
	
	/** Elimina la coppia (key, attribute) dal dizionario 
	* e restituisce l'attributo associato alla chiave se questa e' presente.
	* Se la chiave non e' presente genera l'eccezione java.util.NoSuchElementException 
    */
	public Object remove(Comparable key) {
        int i = linearSearch(key);
        Object elementToRemove = array[i];
        array[i] = array[--arraySize];
        return elementToRemove;
    }

    private int linearSearch(Comparable key) {
        for (int i = 0; i<arraySize; i++) {
            if (array[i].getKey().compareTo(key) == 0) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private class Pair {
        Comparable key;
        Object value;

        public Comparable getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public void setKey(Comparable key) {
            this.key = key;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Pair(Comparable key, Object value) {
            setKey(key);
            setValue(value);
        }
    }

    private void resize() {
        Pair[] resizedArray = new Pair[array.length * 2];
        System.arraycopy(array, 0, resizedArray, 0, array.length);
        array = resizedArray;
    }
}