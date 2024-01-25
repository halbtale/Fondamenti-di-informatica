/**
  * Classe di prova ProvaSIG
  *
  */ 
public class ProvaSIG
{  public static void main(String[] args) throws java.io.IOException
   {  SIG s = new SIG(args[0]);
      System.out.println("\n*** size = " + s.size() + " ***");
      MIS[] c = s.toSortedArray();
      
      System.out.println("\n*** insert ***");
      for (int i = 0; i < c.length; i++)
         System.out.println(c[i]);

      System.out.println("\n*** find e remove ***");
      for (int i = 0; i < c.length; i++)
      {  System.out.println(new MIS(c[i].tempo(), s.find(c[i].tempo())));
         s.remove(c[i].tempo());
      }

      System.out.println("\n*** size = " + s.size() + " ***");
   }
}