//-----------------------------------------------------------------------------

// Classe che implementa l'interfaccia Queue usando un array (array riempito
// solo in parte, oppure array riempito solo nella parte centrale, oppure
// array circolare), con o senza ridimensionamento. La classe sovrascrive 
// il metodo toString
// ....... da completare ............

public class ArrayQueue implements Queue
{
    private static final int INIT_ARRAY_SIZE = 2;
    private Object[] array;
    private int front;
    private int back;

    public ArrayQueue() {
        array = new Object[INIT_ARRAY_SIZE];
        makeEmpty();
    }

    // Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    public boolean isEmpty() {
        return front == back;
    }

    // Svuota la coda
    public void makeEmpty() {
        front = back = 0;
    }
  
    // Restituisce il numero di elementi presenti nella coda
    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back + array.length - front;
        }
    }

    // Inserisce l'oggetto obj nella coda
    public void enqueue(Object obj) {
        checkAndResize();
        back = getModularIndex(back + 1);
        array[getModularIndex(back - 1)] = obj;
    }

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        Object removedElement = array[getModularIndex(front)];
        front = getModularIndex(front + 1);
        return removedElement;
    }

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    public Object getFront() throws EmptyQueueException {
        if (isEmpty()) throw new EmptyQueueException();
        return array[getModularIndex(front)];
    }

    // Metodo toString
    public String toString()
    {
        String output = "";
        if (front <= back) {
            for (int i = front; i<back; i++) {
                output += array[i] +"\n";
            }
        } else {
            for (int i = front; i<array.length; i++) {
                output += array[i] + "\n";
            }
            for (int i = 0; i<back; i++) {
                output += array[i] + "\n";
            }
        }
        return output;
    }

    private void checkAndResize() {
        if (array.length == size() + 1) {
            Object[] resizedArray = new Object[array.length * 2];
            System.arraycopy(array, 0, resizedArray, 0, array.length);
            array = resizedArray;

            if (front > back) {
                System.arraycopy(array, 0, array, array.length / 2, back);
                back += array.length / 2;
            }
        }
    }

    private int getModularIndex(int index) {
        int modularIndex = index % array.length;
        if (modularIndex < 0) modularIndex = array.length - modularIndex;
        return modularIndex;
    }
}