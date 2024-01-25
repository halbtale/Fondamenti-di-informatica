public class ArrayStack implements Stack
{
    public ArrayStack()
    {   v = new Object[INITSIZE];
        makeEmpty();
    }

    public void makeEmpty()
    {   vSize = 0;
    }

    public boolean isEmpty()
    {   return (vSize == 0);
    }

    public void push(Object obj)
    {   if (vSize == v.length)
            v = resize(2*vSize);
        v[vSize++] = obj;
    }
    protected Object[] resize(int newLength)
    {   if (newLength <v.length) throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }

    public Object top()
    {   if (isEmpty())  throw new EmptyStackException();
        return v[vSize - 1];
    }

    public Object pop()
    {   Object obj = top();
        vSize--;
        return obj;
    }

    protected Object[] v;
    protected int vSize; 
    protected static int INITSIZE = 10;

}   
