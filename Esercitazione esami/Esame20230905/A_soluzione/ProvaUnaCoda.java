/*
Nome:
Cognome:
Numero di matricola:
Numero della postazione: 
*/

/* 
Fase di lettura da file: si legge una riga per volta, usando lo Scanner in, e poi dentro la riga si scandiscono le singole parole usando lo Scanner sc.
Fase di estrazione e stampa degli elementi della coda: gli oggetti devono di volta in volta venire estratti per essere stampati, dal momento che solo l'oggetto all'inizio della coda puo` essere ispezionato. In questo modo i token vengono scritti nel file nello stesso ordine con cui sono stati inseriti nella coda.
Gestione non ottimale delle eccezioni di IO: in effetti non sono gestite, e il metodo main dichiara nella propria firma che le propaga
*/

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProvaUnaCoda
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 1) //controllo che da riga di comando sia
        {                     //stata passata esattamente una stringa
            System.out.println("uso: $java ProvaUnaCoda outFile");
            System.exit(1);
        }
      
        // Inserimento elementi da file nella coda
        Scanner in = new Scanner(System.in);
        Queue coda = new ArrayQueue();
        while (in.hasNextLine())
        {  Scanner sc = new Scanner(in.nextLine());
            while (sc.hasNext())
            {   String token = sc.next();
                coda.enqueue(token);
            }
        }
        in.close();
      
        // Svuotamento della coda, e scrittura su file
        PrintWriter writer1 = new PrintWriter(args[0]);

        while (!coda.isEmpty())
            writer1.println((String)coda.dequeue()); 
        writer1.close();
    }
}

