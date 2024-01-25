/* Scrivere un metodo ricorsivo occorrenzeCarRic(car,str) che, dati un carattere c ed una stringa s, restituisce il
numero delle occorrenze di c in s. */

/*
NOME: Alberto 
COGNOME: Heissl
NUMERO MATRICOLA: 2101739
POSTAZIONE: 10
*/

public class Ricorrenze
{
   public static void main(String[] args)   
   {
      char car='s';
      String str="Sassarissimo";


      System.out.println("numero di riccorrenze = " + occorrenzeCarRic(car,str));
   }

   private static int occorrenzeCarRic(char c, String s) {
      if (s.length() == 0) return 0;
      return s.charAt(0) == c ? occorrenzeCarRic(c, s.substring(1, s.length())) + 1 : occorrenzeCarRic(c, s.substring(1, s.length()));
   }

}
