public class MiaCoda
{
    public MiaCoda()
    {   v = new Object[INITSIZE]; 
        makeEmpty();  
    }

    public void makeEmpty()
    {  
        front = back = 0; 
        contatore = 0;
    }

    public boolean isEmpty()
    {  
        return size() == 0; 
    }

    public boolean isFull()
    {
        if (size() == 3)
            return true;
        return false;
    }

    public void enqueue(Object obj)
    {   
        v[back] = obj;
        back = increment(back);
        contatore++;
    }

    public Object dequeue()
    {   Object obj = getFront();
        front = increment(front);
        contatore--;
        return obj;
    }

    public Object getFront()
    {  if (isEmpty()) throw new EmptyQueueException();
        return v[front]; }

    // il metodo increment fa avanzare un indice di una
    // posizione, tornando all'inizio se si supera la fine.
    // Attenzione: non aggiorna direttamente i campi front,back
    private int increment(int index)
    {  
        return (index + 1) % v.length;
    }

    public int size()
    {
       return contatore;
    }

    private Object[] v;
    private int front, back;
    private static int INITSIZE = 3;
    private int contatore;
}

class EmptyQueueException extends java.lang.RuntimeException{}
