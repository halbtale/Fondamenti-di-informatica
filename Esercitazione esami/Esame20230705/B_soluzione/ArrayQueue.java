public class ArrayQueue implements Queue
{
    public ArrayQueue()
    {   v = new Object[INITSIZE]; 
        makeEmpty(); }

    public void makeEmpty()
    {  front = back = 0; }

    public boolean isEmpty()
    {  return (back == front); }

    public void enqueue(Object obj)
    {   if (increment(back) == front) //back e front distano 1
        {   v = resize(2*v.length);
            //se si ridimensiona v e la zona utile della coda e`
            //attorno alla sua fine (cioe` back < front) la seconda
            //meta` del nuovo array rimane vuota e provoca un
            //malfunzionamento della coda, che si risolve spostando
            //la parte di coda che si trova all'inizio dellòùarray
            if (back < front)
            {  System.arraycopy(v, 0, v, v.length/2, back);
                back += v.length/2;
            }
        }
        v[back] = obj;
        back = increment(back);
    }

    public Object dequeue()
    {   Object obj = getFront();
        front = increment(front);
        return obj;
    }

    public Object getFront()
    {  if (isEmpty()) throw new EmptyQueueException();
        return v[front]; }

    // il metodo increment fa avanzare un indice di una
    // posizione, tornando all'inizio se si supera la fine.
    // Attenzione: non aggiorna direttamente i campi front,back
    protected int increment(int index)
    {  return (index + 1) % v.length;
    }

    protected Object[] resize(int newLength)
    {   if (newLength <v.length) throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    protected Object[] v;
    protected int front, back;
    protected static int INITSIZE = 10;
}
