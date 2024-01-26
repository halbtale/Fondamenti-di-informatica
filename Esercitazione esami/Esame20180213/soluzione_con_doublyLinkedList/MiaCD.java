// MiaCDl -- realizzazione di una coda doppia con una catena con doppio collegamento

public class MiaCD implements CD
{ private class Cella
  { Object el;
    Cella s, d;
    Cella (Object x, Cella y, Cella z) { el = x; s = y; d = z; }
  }
  private int taglia;
  private Cella testa, coda;
  public MiaCD ()
  { testa = new Cella(null, null, null);
    coda = new Cella(null, testa, null);
    testa.d = coda;
  }
  public int size () { return taglia; }
  public boolean isEmpty () { return taglia == 0; }
  public void addFirst (Object x) 
  { testa.d = new Cella(x, testa, testa.d);
    testa.d.d.s = testa.d;
    testa.d.s = testa;
    taglia++;
  }
  public void addLast (Object x) 
  { coda.s = new Cella(x, coda.s, coda);
    coda.s.s.d = coda.s;
    coda.s.d = coda;
    taglia++;
  }
  public Object removeFirst () throws EmptyCDException 
  { if (isEmpty()) throw new EmptyCDException();
    taglia--;    
    Object tmp = testa.d.el;
    testa.d = testa.d.d;
    testa.d.s = testa; 
    return tmp; 
  }
  public Object removeLast () throws EmptyCDException
  { if (isEmpty()) throw new EmptyCDException();
    taglia--;    
    Object tmp = coda.s.el;
    coda.s = coda.s.s;
    coda.s.d = coda; 
    return tmp; 
  }
  public Object getFirst () throws EmptyCDException
  { if (isEmpty()) throw new EmptyCDException();
    return testa.d.el; 
  }
  public Object getLast () throws EmptyCDException
  { if (isEmpty()) throw new EmptyCDException();
    return coda.s.el; 
  }
}
