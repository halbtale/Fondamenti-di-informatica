
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IOExample {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("input.txt");
        Scanner in = new Scanner(reader);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }

        reader.close();
    }
}
