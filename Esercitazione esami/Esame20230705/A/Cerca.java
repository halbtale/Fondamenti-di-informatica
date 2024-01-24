// Alberto Heissl 2101739

import java.util.Scanner;

public class Cerca {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci super stringa");
        String superString = in.nextLine();

        System.out.println("Inserisci sotto stringa");
        String subString = in.nextLine();

        int subStartIndex = isSubstring(superString, subString);

        if (subStartIndex == -1) {
            System.out.println(ANSI_RED + "Sottostringa non trovata"+ ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Sottostringa trovata in posizione: "+subStartIndex+ ANSI_RESET);
        }

        in.close();
    }

    private static int isSubstring(String superString, String subString) {
        if (superString.length() < subString.length()) return -1;

        boolean isSubstring = false;
        int start;
        for (start = 0; start <= superString.length() - subString.length(); start++) {
            if (isSubstring(superString, subString, start)) {
                isSubstring = true;
                break;
            }
        }

        if (!isSubstring) return -1;
        return start;
    }

    private static boolean isSubstring(String superString, String subString, int startIndex) {
        boolean isSubstring = true;
        for (int i = 0; i<subString.length() && isSubstring; i++) {
            if (superString.charAt(startIndex+i) != subString.charAt(i)) isSubstring = false;
        }
        return isSubstring;
    }
}