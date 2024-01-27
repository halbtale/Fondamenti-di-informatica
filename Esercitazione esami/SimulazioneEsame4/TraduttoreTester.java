// nome e cognome del candidato, matricola, data, numero della postazione
// Alberto Heissl, 2101739, Postazione 10

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class TraduttoreTester
{   
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  
  public static void main(String[] args)
    {
      // Due nomi di ﬁle di testo, ﬁle1 e ﬁle2, vengono passati come argomenti sulla riga di comando
      if (args.length != 2) {
        System.out.println(ANSI_RED+"Usage: javac TraduttoreTester [inputfile] [outputfile]"+ANSI_RESET);
        System.exit(1);
      }
      String inputFileName = args[0];
      String outputFileName = args[1];

      try {
        // Viene creato un primo esemplare della classe Traduttore, in cui si inseriscono elementi letti dal file1 (scritto nello stesso formato speciﬁcato sopra per il metodo toString di Traduttore).
        DictionaryUD traduttore1 = readFromFile(inputFileName);

        DictionaryUD traduttore2 = readFromStdin();

        traduttore1.update(traduttore2);

        writeDictToFile(traduttore1, outputFileName);
      } catch (IOException e) {
        System.out.println(ANSI_RED+"[Error] reading/writing file has not been successful"+ANSI_RESET);
      }
    }

    private static DictionaryUD readFromFile(String filename) throws IOException {
      DictionaryUD dict;

      FileReader reader = new FileReader(filename);
      try (Scanner scan = new Scanner(reader)) {
        dict = readFromScanner(scan);
      } finally {
        reader.close();
      }
       return dict;
    }

    private static DictionaryUD readFromStdin() {
      try (Scanner scan = new Scanner(System.in)) {
        return readFromScanner(scan);
      }
    }

    private static DictionaryUD readFromScanner(Scanner scan) {
      DictionaryUD dict = new Traduttore();
      while (scan.hasNextLine()) {
          String line = scan.nextLine();
          Scanner lineScan = new Scanner(line);
          lineScan.useDelimiter(" : ");

          String key = lineScan.next();
          String valuesRaw = lineScan.next();
          String[] values = valuesRaw.split(" ");

          dict.insert(key, values);
        }
        return dict;
    } 

    private static void writeDictToFile(DictionaryUD dict, String filename) throws IOException {
      PrintWriter writer = new PrintWriter(filename);
      writer.println(dict);
      writer.close();
    }

}