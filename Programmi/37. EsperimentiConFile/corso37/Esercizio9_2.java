
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Esercizio9_2 {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String testoInput;
        String testoOutput;
        String reversedText = "";

        System.out.println("Inserire il nome del file txt da importare: ");
        testoInput = tastiera.nextLine();
        System.out.println("Inserire il nome del file txt dove stampare il contenuto: ");
        testoOutput = tastiera.nextLine();
        tastiera.close();

        try (FileReader reader = new FileReader(testoInput); Scanner scan = new Scanner(reader)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String reverseLine = "";
                for (int i = 0; i < line.length(); i++) {
                    reverseLine = line.charAt(i) + reverseLine;
                }
                reversedText = reversedText + reverseLine + "\n";
            }
            try (FileWriter writer = new FileWriter(testoOutput)) {
                writer.write(reversedText);
                writer.close();
            } catch (IOException e) {
                System.out.println("ERRORE: file in uscita");
            }
        } catch (IOException e) {
            System.out.println("Errore in lettura delle parole");
        }

    }
}