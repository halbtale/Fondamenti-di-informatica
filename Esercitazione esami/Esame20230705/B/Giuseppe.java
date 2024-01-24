// Alberto Heissl 2101739

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Giuseppe {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Giuseppe.java [filename]");
            System.exit(1);
        }
        try {
            Queue peopleQueue = readFile(args[0]);
            int k = promptForKInput();

            System.out.println("Persone estratte dal cerchio:");
            while (!peopleQueue.isEmpty()) {
                for (int i = 0; i<k-1; i++) {
                    peopleQueue.enqueue(peopleQueue.dequeue());
                }
                String lastPerson = (String) peopleQueue.dequeue();
                System.out.println(lastPerson);
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        } catch (NumberFormatException e) {
            System.out.println("Numero inserito non valido");
        }
    }

    // possibili miglioramenti: lettura robusta con ciclo while e verifica intero positivo
    private static int promptForKInput() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Inserisci k");
        String input = in.nextLine();
        int k = Integer.parseInt(input);

        in.close();

        return k;
    }

    private static Queue readFile(String filename) throws IOException {
        Queue queue = new ArrayQueue();
        int queueSize = 0;

        FileReader reader = new FileReader(filename);
        Scanner in = new Scanner(reader);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            queue.enqueue(line);
            queueSize++;
        }

        in.close();
        reader.close();

        return queue;
    }
}