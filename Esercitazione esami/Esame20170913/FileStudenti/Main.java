import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilaDiCode container = new MiaPilaDiCode();
        try (FileReader reader = new FileReader("input.txt")) {
            Scanner in = new Scanner(reader);

            while (in.hasNextLine()) {
                String input = in.nextLine();
                container.push(input);
            }

            in.close();
        } catch (IOException e) {
            System.out.println("File input.txt non presente");
        }
        while (!container.isEmpty()) {
            System.out.println(container.pop());
        }
    }
}