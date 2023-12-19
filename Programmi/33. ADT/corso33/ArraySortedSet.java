public class ArraySortedSet implements SortedSet { 
    private Comparable[] array; 
    private int arraySize; 
    private static int INITSIZE = 100; 

    public ArraySortedSet() { 
        array = new Comparable[INITSIZE]; arraySize = 0;
    } 
    
    public void makeEmpty() { 
        arraySize = 0; 
    } 
    
    public boolean isEmpty() { 
        return (arraySize == 0); 
    }
    
    public void add(Object x) //metodo di Set 
    { throw new IllegalArgumentException(); } 
    
    public void add(Comparable x) // prestazioni O(n) 
    { ... } //Da completare: ordinamento per inserimento 
    //E` O(n), perche' inseriamo in un array ordinato 
    
    public boolean contains(Object x) //prestaz. O(log n) { ... } // da completare: usare ricerca binaria e compareTo 

    public Comparable[] toSortedArray() // prestaz. O(n) { ... } //da completare (v e’ gia` ordinato...) 

    public Object[] toArray() //come sopra: l'array non deve { return toSortedArray(); } //essere per forza disordinato 
    
    private Comparable[] resize(int newLength) //solito metodo { ... } // da completare //campi di esemplare e variabili statiche 

    public static SortedSet union(SortedSet s1, SortedSet s2) {
        SortedSet mergedSet = new ArraySortedSet();
        Comparable[] array1 = s1.toSortedArray();
        Comparable[] array2 = s2.toSortedArray();
        int i = 0, j = 0;

        while (i < array1.length && j < array2.length) {
            ...
        }
    }
    
}