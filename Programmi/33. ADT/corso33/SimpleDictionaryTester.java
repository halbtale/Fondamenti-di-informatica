import java.util.Scanner;
import java.io.*;
public class SimpleDictionaryTester {
    public static void main(String[] args) throws IOException { //creazione dizionario: leggo dati da file e assumo che
        //il file abbia righe nel formato <numero int> <stringa>
        Scanner infile = new Scanner(new FileReader("file.txt"));
        Dictionary dict = new SortedArrayDictionary();
        // ... oppure = new SortedArrayDictionary();
        while (infile.hasNextLine()) {
            Scanner linescan = new Scanner(infile.nextLine());
            int key = Integer.parseInt(linescan.next());
            String value = linescan.next();
            dict.insert(key, value); //inserisco chiave e valore
        }
        infile.close();
        //ricerca/rimozione dati nel dizionario
        Scanner in = new Scanner(System.in);
        boolean done = false; // continua
        while (!done) // continua
        {
            System.out.println("**** Stampa dizionario ****");
            System.out.println(dict + "\nF=find,R=remove,Q=quit");
            String cmd = in .nextLine();
            if (cmd.equalsIgnoreCase("Q")) {
                done = true;
            } else if (cmd.equalsIgnoreCase("F")) {
                System.out.println("Chiave da trovare?");
                int key = Integer.parseInt( in .nextLine());
                try { //cerca key chiave e restituisce il valore
                    String value = (String) dict.find(key);
                    System.out.println("Valore: " + value);
                } catch (DictionaryItemNotFoundException e) {
                    System.out.println("Chiave non trovata");
                }
            } else if (cmd.equalsIgnoreCase("R")) {
                System.out.println("Chiave da rimuovere?");
                int key = Integer.parseInt( in .nextLine());
                try { //rimuove la coppia identificata da key
                    dict.remove(key);
                    System.out.println("Chiave rimossa");
                } catch (DictionaryItemNotFoundException e) {
                    System.out.println("Chiave non trovata");
                }
            }
        }
    }
}