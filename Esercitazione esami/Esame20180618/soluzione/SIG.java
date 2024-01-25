/**
  * SIG
  * Classe per esercitazione: Laboratorio 9
  * rappresenta un segnale campionato
  */ 
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class SIG implements Dizionario
{
   private static final int INITIAL_DIM = 1;

   private MIS[] v;
   private int vSize;

   /**
      crea un dizionario vuoto e inserisce le coppie t/v lette da file
      @param filename nome del file da cui leggere i dati
      @throws IOException se il file non e' presente
   */
   public SIG(String filename) throws IOException
   {
      // creazione e inizializzazione di un dizionario vuoto
      makeEmpty();

      // apertura del file
      Scanner in = new Scanner(new FileReader(filename));
      
      // lettura per riga del file
      int lineCount = 0;
      while (in.hasNextLine())
      {
         lineCount++;
         String s = in.nextLine();

         Scanner tok = new Scanner(s);
         tok.useDelimiter("[ ()]+");

         // estrazione dei token dalla riga
         while (tok.hasNext())
         {
           try
           {
              int n = Integer.parseInt(tok.next());
              double d = Double.parseDouble(tok.next());

              // inserimento della coppia
              insert(n, d);
           }
           catch (NoSuchElementException e)
           {
              System.err.println("errore riga " + lineCount + " : " + s);
           }
           catch (NumberFormatException e)
           {
              System.err.println("errore formato riga " + lineCount + " : " + s);
           }
         }
         tok.close();
      }
      
      in.close();
   }
   
   public void makeEmpty()
   {
      v = new MIS[INITIAL_DIM];
      vSize = 0;
   }
   
   public boolean isEmpty()
   {
      return vSize == 0;
   }
   
   public int size()
   {
      return vSize;
   }

   /**
      inserisce ordinatamente la coppia t/d nel dizionario.
      Complessita' temporale: O(n)
      @param t la chiave
      @param valore il valore associato alla chiave specificata
      */
   public void insert(int tempo, double valore)
   {
      MIS c = new MIS(tempo, valore);

      int index = findIndex(tempo);
      if (index == -1)
      {
         if (vSize >= v.length)
            v = resize(v, 2 * v.length);

         int j;
         
         for (j = vSize; j > 0 && c.compareTo(v[j - 1]) < 0; j--)
            v[j] = v[j - 1];

         v[j] = c;
         vSize++;
      }
      else
         v[index] = c;
   }

   // O(logn)
   public double find(int tempo) throws NoSuchElementException
   {
      int index = findIndex(tempo);
      
      if (index == -1)
         throw new NoSuchElementException();
         
      return v[index].valore();
   }
   
   // O(n)
   public void remove(int tempo)
   {
      int index = findIndex(tempo);
      
      if (index != -1)
      {
         for (int i = index; i < vSize - 1; i++)
            v[i] = v[i + 1];

         vSize--;
      }
   }
   
   // O(n)
   public MIS[] toSortedArray()
   {
      MIS[] c = new MIS[vSize];
      for (int i = 0; i < vSize; i++)
         c[i] = new MIS(v[i].tempo(), v[i].valore());
         
      return c;   
   }
   
   private int findIndex(int tempo)
   {
      MIS target = new MIS(tempo, 0);
      return binSearch(v, 0, vSize - 1, target);
   }
      
   private int binSearch(MIS[] a, int from, int to, MIS t)
   {
      if (to < from)
         return -1;
         
      int m = (from + to) / 2;
      
      if (t.compareTo(a[m]) == 0)
         return m;

      else if (t.compareTo(a[m]) < 0)
         return binSearch(a, from, m - 1, t);
      else
         return binSearch(a, m + 1, to, t);
   }

   private MIS[] resize(MIS[] s, int length)
   {
      MIS[] c = new MIS[length];

      int minLength = s.length < length ? s.length : length;

      for (int i = 0; i < minLength; i++)
         c[i] = s[i];
         
      return c;
   }
}