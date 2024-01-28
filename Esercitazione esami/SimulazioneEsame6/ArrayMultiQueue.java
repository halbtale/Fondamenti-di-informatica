
//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia MultiQueue usando un array di N code. 
// La classe sovrascrive il metodo toString
// ....... da completare ............

public class ArrayMultiQueue implements MultiQueue
{
    Queue[] arrayQueue;

    //costruttore ......da completare ......
    // crea una multicoda vuota, costituita da una sequenza di N code vuote,
    // con N > 0
    public ArrayMultiQueue(int N)
    {
        if (N <= 0) throw new IllegalArgumentException();
        arrayQueue = new ArrayQueue[N];
        for (int i = 0; i<N; i++) {
            arrayQueue[i] = new ArrayQueue();
        }
    }          

    // Restituisce true se la multicoda e` vuota, cioe` se tutte le N
    // code della multicoda sono vuote. Restituisce false se la multicoda
    // contiene almeno un elemento, cioe` se almeno una delle N code della
    // multicoda contiene almeno un elemento
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i<arrayQueue.length; i++) {
            if (!arrayQueue[i].isEmpty()) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    // Svuota la multicoda, cioe` svuota tutte le N code della multicoda
    public void makeEmpty() {
        for (int i = 0; i<arrayQueue.length; i++) {
            arrayQueue[i].makeEmpty();
        }
    }
  
    // Inserisce l'oggetto obj nella multicoda. Tra tutte le N code della
    // multicoda, l'oggetto viene accodato a quella che contiene il minor
    // numero di elementi. Nel caso in cui piu` code contengano un numero
    // di elementi pari al minimo, la scelta è indifferente
    public void add(Object obj) {
        Queue minQueue = arrayQueue[0];

        for (int i = 1; i<arrayQueue.length; i++) {
            if (arrayQueue[i].size() < minQueue.size()) {
                minQueue = arrayQueue[i];
            }
        }

        minQueue.enqueue(obj);
    }

    // Disaccoda dalla i-esima coda il suo primo elemento e lo restituisce.
    // L'indice intero i specifica quale e` la coda da cui disaccodare il 
    // primo elemento. Di conseguenza i deve essere tale che 0 <= i < N.
    // Lancia EmptyQueueException se la la i-esima coda e` vuota
    public Object remove(int i) throws EmptyQueueException {
        if (i >= arrayQueue.length || i<0) throw new IllegalArgumentException();
        return arrayQueue[i].dequeue();
    }

    //metodo toString ..... da completare .........
    public String toString()
    {
        String output = "";
        for (int i = 0; i<arrayQueue.length; i++) {
            output += "CODA "+i+":\n";
            output += arrayQueue[i];
        }
        return output;
    }          

}