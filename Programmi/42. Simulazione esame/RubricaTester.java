// nome e cognome del candidato, phone, data, numero della postazione
// ALBERTO HEISSL, 2101739, 11/01/2024, IL_MIO_MAC

//istruzioni di import...
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RubricaTester {
    public static void main(String[] args) throws Exception {
        if (args.length != 2)
            throw new IllegalArgumentException();

        String file1 = args[0];
        String file2 = args[1];

        Rubrica rubrica1 = readFromFile(file1);
        Rubrica rubrica2 = new Rubrica();

        boolean promptForInput = true;

        Scanner in = new Scanner(System.in);
        while (promptForInput) {
            String input = promptForNome(in);
            if (input.equalsIgnoreCase("Q")) {
                promptForInput = false;
            } else {
                moreBetweenRubriche(input, rubrica1, rubrica2);
            }
        }
        in.close();

        PrintWriter writer = new PrintWriter(file2);
        writer.println(rubrica2);
        writer.close();
    }

    private static String promptForNome(Scanner in) {
        System.out.print("Inserisci il nome: ");
        String nome = in.nextLine();
        return nome;
    }

    private static void moreBetweenRubriche(String name, Rubrica rubrica1, Rubrica rubrica2) {
        Object phone = rubrica1.find(name);
        rubrica1.remove(name);
        rubrica2.insert(name, phone);
    }

    private static Rubrica readFromFile(String filename) throws IOException {
        Rubrica rubrica = new Rubrica();
        FileReader reader = new FileReader(filename);
        Scanner in = new Scanner(reader);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner scan = new Scanner(line);
            scan.useDelimiter(" : ");
            String nome = scan.next();
            String numerophone = scan.next();
            rubrica.insert(nome, Long.parseLong(numerophone));
            scan.close();
        }

        in.close();
        reader.close();

        return rubrica;
    }
}