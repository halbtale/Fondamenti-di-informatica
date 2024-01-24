/*
Nome:
Cognome:
Numero di matricola:
Numero della postazione: 
*/


import java.util.Scanner;

public class Cerca
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire la prima stringa");
        String superStringa = in.nextLine();
        System.out.println("Inserire la seconda stringa");
        String sottoStringa  = in.nextLine();

        int index = confronto(superStringa,sottoStringa); //cfr. il metodo confronto sotto
        if (index >=0)
            System.out.println("E` una sottostringa: dal carattere " + index);
        else
            System.out.println("Non e` una sottostringa");
    }



    /*
      Questo metodo verifica se sottoStringa  e` una sottostringa di superStringa. In caso positivo
      restituisce l'indice iniziale della sottostringa di superStringa che coincide con
      sottoStringa , altrimenti restituisce il valore -1

      L'algoritmo realizzato in questo metodo ragiona cosi`: confrontiamo sottoStringa  
      con la sottostringa di superStringa che
      1) comincia all'indice i1
      2) e` lunga come sottoStringa  
      Se coincidono allora sottoStringa  e` una sottostringa di superStringa, altrimenti si     
      incrementa i1 e si riprova a fare il confronto.
    */

    public static int confronto(String superStringa, String sottoStringa)
    {
        /*
          Usiamo due variabili int, i1, e i2, che "puntano" ai caratteri
          di superStringa ed sottoStringa, rispettivamente
          Osservare il valore massimo assunto da i1: non ha senso cercare
          in superStringa a partire da una posizione in cui il numero di caratteri
          successivi e' minore del numero di caratteri presenti in sottoStringa 
        */  
        for (int i1 = 0; i1 <= superStringa.length() - sottoStringa.length(); i1++ )
        {
            /*
                se potessimo usare tutti i metodi di String, potremmo estrarre
                da sottoStringa la sottostringa che inizia in posizione i1 e che ha
                lunghezza uguale a quella di sottoStringa:

                String maybeSub = superStringa.substring(i1, i1+sottoStringa.length());
                if (maybeSub.equals(sottoStringa))
                    return i1;

                Senza usare tali metodi, realizziamo lo stesso algoritmo
            */

            int i2=0;
            while (i2 < sottoStringa.length() && superStringa.charAt(i1+i2) == sottoStringa.charAt(i2) )
                i2++;
            if (i2 == sottoStringa.length())
                return i1;
        }
        return -1;
    }
}