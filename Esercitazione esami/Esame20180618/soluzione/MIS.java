/**
  * MIS
  * Classe per esercitazione: Laboratorio 9
  * rappresenta un campione di una misura
  */
public class MIS implements Comparable
{
   int tempo;
   double valore;

   public MIS(int t, double d)
   {
      tempo = t;
      valore = d;
   }

   public int tempo()
   {
      return tempo;
   }
   
   public double valore()
   {
      return valore;
   }

   public int compareTo(Object x)
   {
      return tempo - ((MIS) x).tempo;
   }

   public String toString()
   {
      return "(" + tempo + " " + valore + ")";
   }
}