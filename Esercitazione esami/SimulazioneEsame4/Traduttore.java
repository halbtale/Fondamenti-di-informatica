class Traduttore implements DictionaryUD
{   
    private static final int INIT_ARRAY_SIZE = 10;
    private WordPair[] array;
    private int arraySize;

    public Traduttore() {
        array = new WordPair[INIT_ARRAY_SIZE];
        makeEmpty();
    }

    //costruttori e metodi pubblici ......da completare ......
        /*
     verifica se il dizionario contiene almeno una coppia chiave/valore
    */
    public boolean isEmpty() {
        return arraySize == 0;
    }

    /* 
     svuota il dizionario
    */
    public void makeEmpty(){
        arraySize = 0;
    }

    /*
     Inserisce un elemento nel dizionario. L'inserimento va sempre a buon fine.
     Se la chiave non esiste la coppia key/value viene aggiunta al dizionario; 
     se la chiave esiste gia' il valore ad essa associato viene sovrascritto 
     con il nuovo valore; se key e` null viene lanciata IllegalArgumentException
    */
    public void insert(Comparable key, Object value) {
        if (key == null) throw new IllegalArgumentException();

        WordPair newPair = new WordPair((String) key, (String[]) value);

        if (array.length == arraySize + 1) resize();

        try {
            remove(key);
        } catch (DictionaryItemNotFoundException e) {}

        arraySize++;

        int i;
        for (i = arraySize - 1; i > 0 && array[i-1].getWord().compareTo((String) key) > 0; i--) {
            array[i] = array[i - 1];
        }
        array[i] = newPair;
    }

    /*
     Rimuove dal dizionario l'elemento specificato dalla chiave key
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException 
    */
    public void remove(Comparable key) {
        int indexToRemove = binarySearch(key);

        arraySize--;
        for (int i = indexToRemove; i<arraySize; i++) {
            array[i] = array[i+1];
        }
    }

    /*
     Cerca nel dizionario l'elemento specificato dalla chiave key
     La ricerca per chiave restituisce soltanto il valore ad essa associato
     Se la chiave non esiste viene lanciata DictionaryItemNotFoundException
    */
    public Object find(Comparable key) {
        return array[binarySearch(key)].getTranslations();
    }

    private int binarySearch(Comparable key) {
        return binarySearch(key, 0, arraySize - 1);
    }

    private int binarySearch(Comparable key, int start, int end) {
        if (key == null) throw new IllegalArgumentException();
        if (start > end) throw new DictionaryItemNotFoundException();
        int mid = (start+end) / 2;
        if (array[mid].getWord().compareTo((String) key) == 0) {
            return mid;
        } else if (array[mid].getWord().compareTo((String) key) > 0) {
            return binarySearch(key, start, mid - 1);
        } else {
            return binarySearch(key, mid+1, end);
        }
    }

    /* 
     Aggiorna il contenuto del dizionario (parametro implicito del metodo) con 
     il contenuto del dizionario newdict (parametro esplicito del metodo). 
     Piu' precisamente:
     a) se newdict contiene una chiave key non presente nel dizionario, la 
        coppia corrispondente (key value) viene scritta nel dizionario
     b) se newdict contiene una chiave key gia' presente nel dizionario, la 
        coppia (key value) presente nel dizionario viene sovrascritta da quella 
        di newdict 
    */
    public void update(DictionaryUD newdict) {
        Traduttore newTrad = (Traduttore) newdict;
        for (int i = 0; i<newTrad.arraySize; i++) {
            WordPair pair = newTrad.array[i];
            insert(pair.getWord(), pair.getTranslations());
        }
    }


    //classe privata WordPair: non modificare!!
    private class WordPair
    {   public WordPair(String word, String[] translations)
        {   this.word = word; 
            this.translations = translations;
        }
      
        public String getWord() 
        { return word; }
        public String[] getTranslations() 
        { return translations; }
        /*
            Restituisce una stringa contenente
            - la parola word
            - un carattere di separazione ( : )
            - gli elementi dell'array translations, separati da uno spazio
        */
        public String toString() 
        {   String retString = word + " :";
            for (int i = 0; i < translations.length; i++)
	        retString += " " + translations[i];
            return retString;
        }
        //campi di esemplare
        private String word;
        private String[] translations;
    }

    private void resize() {
        WordPair[] resizedArray = new WordPair[array.length * 2];
        System.arraycopy(array, 0, resizedArray, 0, array.length);
        array = resizedArray;
    }

    public String toString()
    {
        String output = "";  
        for (int i = 0; i<arraySize; i++) {
            output += array[i] + "\n";
        }
        return output;
    }

}
