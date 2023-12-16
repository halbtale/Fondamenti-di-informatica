
import java.util.Scanner;

public class StringRotator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Inserisci una stringa da ruotare: ");
        String tokenToRotate = in.nextLine();

        System.out.print("Inserisci il numero di caratteri per cui vuoi ruotarla: ");
        int n = in.nextInt();

        String rotatedToken = rotateToken(tokenToRotate, n);

        System.out.println(rotatedToken);
    }

    private static String rotateToken(String token, int n) {
        if (n == 0)
            return token;

        char[] letters = splitStringToCharList(token);

        if (n < 0)
            n = token.length() + n;

        for (int i = 0; i < n; i++) {
            char lastLetter = letters[letters.length - 1];
            for (int j = letters.length - 2; j >= 0; j--) {
                letters[j + 1] = letters[j]; // sposta ogno lettera a destra
            }
            letters[0] = lastLetter;
        }

        return String.valueOf(letters);
    }

    private static char[] splitStringToCharList(String s) {
        char[] cList = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            cList[i] = s.charAt(i);
        }
        return cList;
    }
}
