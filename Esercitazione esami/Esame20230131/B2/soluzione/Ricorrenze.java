/* Scrivere un metodo ricorsivo occorrenzeCarRic(car,str) che, dati un carattere c ed una stringa s, restituisce il
numero delle occorrenze di c in s. */

// Soluzione con ricorsione annidata


public class Ricorrenze
{
   public static void main(String[] args)   
   {
    
char car='s';
String str="Sassarissimo";

System.out.println("numero di riccorrenze = " + occorrenzeCarRic(car,str));

}

  public static int occorrenzeCarRic (char c, String s) {
    return occorrenzeCarRic(c,s,0);
}
  public static int occorrenzeCarRic (char c, String s, int i) {
    if (i == s.length())
      return 0;
    if (s.charAt(i) == c)
      return 1 + occorrenzeCarRic(c,s,i+1);
    return occorrenzeCarRic(c,s,i+1);
}
}

/* Soluzione con ricorsione in testa
  public static int occorrenzeCarRic (char c, String s) {
    return occorrenzeCarRic(c,s,0,0);
}
  public static int occorrenzeCarRic (char c, String s, int i, int k) {
    if (i == s.length())
      return k;
    if (s.charAt(i) == c)
      return occorrenzeCarRic(c,s,i+1,k+1);
    return occorrenzeCarRic(c,s,i+1,k);
}
*/