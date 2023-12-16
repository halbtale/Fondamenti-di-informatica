package corso27;

import java.util.Scanner;

public class StringReverser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("inserire una riga: ");
        String line = in.nextLine();
        String lineReversed = "";

        for (int i = 0; i < line.length(); i++) {
            lineReversed = line.charAt(i) + lineReversed;
        }

        System.out.print("riga inversa: ");
        System.out.println(lineReversed);

        in.close();
    }
}