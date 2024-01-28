//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Interfaccia che rappresenta il tipo di dati astratto coda

public interface Queue
{   // Restituisce true se la coda e` vuota. Restituisce false se la coda
    // contiene almeno un elemento
    boolean isEmpty(); 

    // Svuota la coda
    void makeEmpty();
  
    // Restituisce il numero di elementi presenti nella coda
    int size();

    // Inserisce l'oggetto obj nella coda
    void enqueue(Object obj);

    // Elimina dalla coda il primo oggetto, e lo restituisce.
    // Lancia EmptyQueueException se la coda e` vuota
    Object dequeue() throws EmptyQueueException;

    // Restituisce il primo oggetto della coda, senza estrarlo
    // Lancia EmptyQueueException se la coda e` vuota
    Object getFront() throws EmptyQueueException;
}

//-----------------------------------------------------------------------------

// NON MODIFICARE!
// Eccezione lanciata da dequeue e getFront quando la coda e` vuota

class EmptyQueueException extends RuntimeException { }