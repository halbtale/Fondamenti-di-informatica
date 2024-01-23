/*
Nome: Alberto 
Cognome: Heissl
Numero di matricola: 2101739
Numero della postazione: Mac
*/

import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProvaUnaCoda {
    public static void main(String[] args) throws IOException {

        // controllo parametri (nome del file di output)
        if (args.length != 1) throw new IllegalArgumentException(); // migliora messaggio d'errore
        String outputFilename = args[0];

        // crea coda
        Queue queue = new ArrayQueue();

        // Inserimento elementi da file nella coda
        Scanner in = new Scanner(System.in);

        // consigliato invece uso di nextLine
        while(in.hasNext()) {
            String token = in.nextLine();
            queue.enqueue(token);
        }

        in.close();

        // Svuotamento della coda, e scrittura su file
        PrintWriter writer = new PrintWriter(outputFilename);
        
        while (!queue.isEmpty()) {
            writer.println(queue.dequeue());
        }

        writer.close();
    }
}
