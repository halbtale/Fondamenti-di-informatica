 /**
    Fondamenti di Informatica 1
    Prova pratica di programmazione
    
    Struttura dati che realizza l'interfaccia Dictionary.
    Usa un array ordinato riempito solo in parte a ridimensionamento dinamico

    @author S. Canazza
    @version 2018
 */  
    
import java.util.NoSuchElementException; 

public class D implements Dictionary
{
  private static final int DIM = 1;

  private Coppia[] v;
  private int vSize;
  
  public D()
  {
  	 makeEmpty();
  }
  
  public boolean isEmpty()
  {
  	 return vSize == 0;
  }
  
  public void makeEmpty()
  {
  	 v = new Coppia[DIM];
  	 vSize = 0;
  }
  
  public int size()
  {
  	 return vSize;
  }
  
  /**
    inserisce la coppia (key, attribute) nel dizionario con verifica di
    univocita' della chiave. Se la chiave e' gia' presente sovrascrive la coppia.
    complessita' temporale: O(n) determinata dall'ordinamento
    @param key la chiave
    @param attribute l'attributo
  */
  public void insert(Comparable key, Object attribute)
  {
  	 int i = findPos(key);
  	 Coppia target =  new Coppia(key, attribute);

  	 if (i == -1)
  	 {
  	 	if (vSize >= v.length)
  	 	  v = resize(v, 2 * v.length);

      int j;
      for (j = vSize; j > 0 && target.compareTo(v[j - 1]) < 0; j--)
        v[j] = v[j - 1];

      v[j] = target;
      vSize++;
  	 }
    else
      v[i] = target;
  }

  /**
    ricerca la chiave key nel dizionario. Se la chiave e' presente,
    restituisce l'attributo, altrimenti lancia un'eccezione.
    complessita' temporale O(log n)
    @param key la chiave
    @return l'attributo associato alla chiave
    @throws NoSuchElementException se la chiave non e' presente nel dizionario
  */
  public Object find(Comparable key) throws NoSuchElementException
  {
    int i = findPos(key);

  	 if (i == -1)
      throw new NoSuchElementException();

    return v[i].attribute;
  }
  
  /**
    rimuove la coppia (key, attribute) dal dizionario.
    Se la chiave non e' presente lancia un'eccezione.
    complessita' temporale O(n)
    @param key la chiave
    @param attribute l'attributo
  */
  public Object remove(Comparable key) throws NoSuchElementException
  {
    int i = findPos(key);
  	 if (i == -1)
      throw new NoSuchElementException();

    Object tmp = v[i].attribute;
    v[i] = v[vSize - 1];
    vSize--;
    return tmp;
  }
  
  /*
    ricerca binaria
    complessita' temporale o( log n)
  */
  private int findPos(Comparable k)
  {
    Coppia target = new Coppia(k, null);

    int from = 0;
    int to = vSize - 1;

    while (from <= to)
    {
    	int mid = (from + to) / 2;

    	if (v[mid].compareTo(target) == 0)
    	  return mid;
    	else if (v[mid].compareTo(target) < 0)
    	  from = mid + 1;
    	else
         to = mid -1 ;
     }

  	 return -1;
  }

  private Coppia[] resize(Coppia[] a, int size)
  {
  	 Coppia[] nuovaCoppia = new Coppia[size];
  	 int dim = size < a.length ? size : a.length;
  	 for (int i = 0; i < dim; i++)
  	   nuovaCoppia[i] = a[i];
  	   
  	 return nuovaCoppia;
  }
  
  class Coppia implements Comparable
  {
  	 private Comparable key;
  	 private Object attribute;
  	 
  	 public Coppia(Comparable k, Object att)
  	 {
  	 	key = k;
  	 	attribute = att;
  	 }
  	 
  	 public int compareTo(Object obj)
  	 {
  	 	Coppia c = (Coppia) obj;
  	 	return key.compareTo(c.key);
  	 }
  }
}
