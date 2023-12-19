import java.util.Arrays;

public class SubstringGeneratorREC {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(substringsREC(args[0])));
    }

    public static String[] substringsREC(String s) {
        if (s.length() == 0) return new String[0];
        if (s.length() == 1) {
            String[] uniqueElement = new String[1];
            uniqueElement[0] = s;
            return uniqueElement;
        }
        String[] startSubstrings = new String[s.length()];
        
        for (int i = 0; i<startSubstrings.length; i++) {
            startSubstrings[i] = s.substring(0, i + 1);
        }

        String[] endSubstrings = substringsREC(s.substring(1));
        String[] totalSubstrings = new String[startSubstrings.length + endSubstrings.length];
        int size = 0;

        for (int i = 0; i<startSubstrings.length; i++) {
            totalSubstrings[size++] = startSubstrings[i];
        }

        for (int i = 0; i<endSubstrings.length; i++) {
            totalSubstrings[size++] = endSubstrings[i];
        }

        return totalSubstrings;
    }
}