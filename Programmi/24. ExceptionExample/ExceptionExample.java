import java.io.*;
import java.util.*;

public class ExceptionExample {
    public static void main(String[] args) throws IOException {
        read();
    }

    private static void read() throws IOException {
        String filename = "filename.txt";
        FileReader reader = new FileReader(filename);
        Scanner in = new Scanner(reader);
        reader.close();
    }
}
