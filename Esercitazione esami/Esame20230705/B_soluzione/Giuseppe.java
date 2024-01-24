/*
Nome:
Cognome:
Numero di matricola:
Numero della postazione: 
*/

import java.io.*;
import java.util.*;

public class Giuseppe
{
    public static void main(String[] args)
    {
        //gestione argomento da riga di comando
        if (args.length != 1)
        {   System.err.println("uso: $java Giuseppe nomeFile");
            System.exit(1);
        }

        //lettura robusta (con ciclo-e-mezzo) di k intero >0 da standard input 
        //Questa volta, per uscire dal ciclo, invece della solita condizione 
        //done == true usiamo, in maniera equivalente, la condizione k > 0
        Scanner in = new Scanner(System.in);
        int k = 0;
        while(k <= 0)
        {   System.out.println("Lunghezza contatore (intero positivo)?");
            try{k = Integer.parseInt(in.nextLine()); }
            catch(NumberFormatException e)
            {   System.out.println("Deve essere un intero!"); }
        }

        // creazione coda, con lettura robusta da file
        Queue persone = null;
        int n = 0; // numero di persone
        try{
            Scanner nomi = new Scanner(new FileReader(args[0])); //lettura file
            persone = new ArrayQueue();
            n = 0; 
            while (nomi.hasNextLine())
            {   n++;
                persone.enqueue(nomi.nextLine());
            }
        }
        catch (IOException e) {
            System.out.println("Errore lettura file");
            System.exit(1);
        }

        //simulazione 
        System.out.println("\nPersone estratte dal cerchio:");
        while (!persone.isEmpty()) //finche` ci sono persone 
        {
            for (int j = 0; j < k-1; j++)  // lettura contatore
                persone.enqueue(persone.dequeue()); // scorro circolarmente
          //l'ultima persona indicato non viene riaccodato:
          System.out.println(persone.dequeue());
        }
    }
}
