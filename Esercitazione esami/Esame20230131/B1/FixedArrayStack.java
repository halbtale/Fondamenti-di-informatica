public class FixedArrayStack implements Stack
{  //costruttore
   public FixedArrayStack()
   {  v = new Object[INITSIZE];
      // per rendere vuota la struttura invochiamo
      // il metodo makeEmpty: è sempre meglio evitare
      // di scrivere codice ripetuto
      makeEmpty();
   }

   // dato che Stack estende Container,
   // occorre realizzare anche i suoi metodi
   public void makeEmpty()
   {  vSize = 0; }

   public boolean isEmpty()
   {  return (vSize == 0); }
                                             
  public void push(Object obj)               {  if (vSize == v.length)
         throw new FullStackException();
      v[vSize++] = obj;
      }
   public Object top()
   {  if (isEmpty())
         throw new EmptyStackException();
      return v[vSize - 1];
      }
   public Object pop()
   {  Object obj = top(); //top fa controllo di pila vuota
   vSize--;
   return obj;
   }
  //campi di esemplare e variabili statiche
  protected Object[] v;//array riempito solo in parte 
  protected int vSize;//ci è comodo usare var. protected
  public static final int INITSIZE = 100;
}