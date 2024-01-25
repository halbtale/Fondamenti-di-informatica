// Nome: Alberto 
// Cognome: Heissl 
// Matricola: 2101739
// Postazione: 10
// 23 Febbraio 2023
// MI RITIRO: NO


public class Sequenze
{  
    public static void main(String[] args)
    {
        if (args.length != 2) {
            System.err.println("Uso: java Sequenze [stringa1] [stringa2]");
            System.exit(1);
        }

        String stringa1 = args[0];
        String stringa2 = args[1];

        int foundI = -1;
        int foundJ = -1;
        int foundN = 0;
        String foundSubstring = "";

        for (int i = 0; i<stringa1.length(); i++) {
            for (int j = 0; j<stringa2.length(); j++) {
                for (int n = 1; n<Math.min(stringa1.length() - i, stringa2.length() - j); n++) {
                    if (stringa1.substring(i, i+n).equals(stringa2.substring(j, j+n))) {
                        if (n > foundN) {
                            foundI = i;
                            foundJ = j;
                            foundN = n;
                            foundSubstring = stringa1.substring(i, i+n);
                        }
                    }
                }
            }
        }

        if (foundN == 0) {
            System.out.println("Nessuna sottostringa in comune trovata");
        } else {
            System.out.println("Sottostringa trovata: "+foundSubstring);
            System.out.println("Indice iniziale in s1: "+foundI);
            System.out.println("Indice iniziale in s2: "+foundJ);
        }

    }
}
