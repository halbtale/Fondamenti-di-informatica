public class ArrayDeque implements Deque
{
    public ArrayDeque()
    {   v = new Object[INITSIZE]; 
        makeEmpty();
    }

    public void makeEmpty()
    {  first = last = 0; }

    public boolean isEmpty()
    {  return (last == first); }

    public int size()
    {   int size;
        if (last >= first) size = last-first;
        else size = last + v.length - first;
        return size;
    }

    public void addLast(Object obj)
    {   if (increment(last) == first) //last e first distano 1: array pieno
            resize(2*v.length);   
        v[last] = obj;
        last = increment(last);
    }

    public void addFirst(Object obj)
    {   if (decrement(first) == last) //last e first distano 1: array pieno
            resize(2*v.length);
        first = decrement(first);
        v[first] = obj;
    }

    public Object removeFirst()
    {   Object obj = getFirst();
        first = increment(first);
         return obj;
    }

    public Object removeLast()
    {   Object obj = getLast();
        last = decrement(last);
            return obj;
    }

    public Object getFirst()
    {  if (isEmpty()) throw new EmptyDequeException();
        return v[first];
    }

    public Object getLast()
    {  if (isEmpty()) throw new EmptyDequeException();
        return v[decrement(last)];
    }

    public String toString()
    {   String s = "[";
        if (isEmpty())
            s +="]";
        else
        {   for (int i = 0; i < size(); i++)
                s += v[(i+first)%v.length] + ", ";
            s += "\b\b]";
        }        
        return s;
    }

    //avanzamento/arretramento di un indice di una posizione, rimanendo nei 
    //limiti della lunghezza dell'array
    protected int increment(int index)
    {  return (index + 1) % v.length;
    }
    protected int decrement(int index)
    {  return (index + v.length - 1) % v.length;
    }

    //ridimensionamento dell'array circolare v, campo di esemplare
    protected void resize(int newLength)
    {   if (newLength < v.length) throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        v = newv;
        if (last < first)         
            {  System.arraycopy(v, 0, v, v.length/2, last);
                last += v.length/2;
            }
    }

    protected Object[] v;
    protected int first, last;
    protected static int INITSIZE = 2;
}
