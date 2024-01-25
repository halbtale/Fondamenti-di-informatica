// Nome:
// Cognome:
// Matricola: 
// Postazione: 
// 23 Febbraio 2023
// MI RITIRO: NO

// Effettuiamo la ricerca di tutte le sottostringhe comuni a partire da ogni carattere della prima stringa e da ogni carattere della seconda stringa.<br>

public class Sequenze
{  
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Uso: $java <stringa1> <stringa2>");
            System.exit(1);
        }
    
        String s1 = args[0];
        String s2 = args[1];
        String max = "";      // conterra` la massima sottostringa comune
        int start1 = 0;       // conterra` l'indice di inizio di max in s1
        int start2 = 0;       // conterra` l'indice di inizio di max in s2
    
        // i e' l'indice di inizio della sottostringa in s1
        for (int i = 0; i < s1.length() - max.length(); i++)
        {  
            for (int j = 0; j < s2.length() - max.length(); j++)
            {
                int k = 0; 
                boolean isInSubstring = true; 
                while (i+k < s1.length() && j+k < s2.length() && isInSubstring)
                {
                    if (s1.charAt(i+k) != s2.charAt(j+k))
                        isInSubstring = false; 
                    else
                        k++;
                }
                if (k > max.length())
                {                     
                    max = s1.substring(i, i+k);
                    start1 = i;
                    start2 = j;
                }
            }
        }
        System.out.println("Massima sottostringa comune: \"" + max +"\"");
        System.out.println("Indice iniziale in s1: " + start1);
        System.out.println("Indice iniziale in s2: " + start2);


    }
}