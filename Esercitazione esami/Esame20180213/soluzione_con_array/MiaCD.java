public class MiaCD implements CD
{ private Object[] v = new Object[1];
  private int primo, ultimo, taglia;
  public int size () { return taglia; }
  public boolean isEmpty () { return taglia == 0; }
  private void raddoppia ()
  { Object[] tmp = new Object[v.length * 2];
    for (int i = 0; i < taglia; i++)
    { primo++;
      if (primo == v.length) primo = 0;      
      tmp[i] = v[primo];
    }
    primo = tmp.length - 1;
    ultimo = taglia;
    v = tmp;
  }
  public void addFirst (Object x) 
  { if (taglia == v.length) raddoppia();
    if (taglia == 0)
    { v[0] = x; primo = v.length - 1; ultimo = 1; }
    else
    { v[primo] = x; primo--; if (primo == -1) primo = v.length - 1; }
    taglia++;
  }
  public void addLast (Object x) 
  {if (taglia == v.length) raddoppia();
    if (taglia == 0)
    { v[0] = x; primo = v.length - 1; ultimo = 1; }
    else
    { v[ultimo] = x; ultimo++; if (ultimo == v.length) ultimo = 0; }
    taglia++;
  }
  public Object removeFirst () throws EmptyCDException 
  { if (isEmpty()) throw new EmptyCDException();
    taglia--;    
    primo++;
    if (primo == v.length) primo = 0;
    return v[primo]; 
  }
  public Object removeLast () throws EmptyCDException
  { if (isEmpty()) throw new EmptyCDException();
    taglia--;    
    ultimo--;
    if (ultimo == -1) ultimo = v.length - 1;
    return v[ultimo]; 
  }
  public Object getFirst () throws EmptyCDException
  { if (isEmpty()) throw new EmptyCDException();
    int p = primo + 1;
    if (p == v.length) p = 0;
    return v[p]; 
  }
  public Object getLast () throws EmptyCDException
  { if (isEmpty()) throw new EmptyCDException();
    int u = ultimo - 1;
    if (u == -1) u = v.length - 1;
    return v[u]; 
  }
}

