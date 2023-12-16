
import java.util.Arrays;

public class SubstringGeneratorIT {
    public static void main(String[] args) {
        String mainString = args[0];

        String[] substrings = substringsIT(mainString);

        System.out.println(Arrays.toString(substrings));

    }

    public static String[] substringsIT(String s) {
        String[] substrings = new String[s.length() * s.length() + 1];
        int substringsSize = 0;

        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            for (int endIndex = s.length(); endIndex > startIndex; endIndex--) {
                substrings[substringsSize++] = s.substring(startIndex, endIndex);
            }
        }

        return Arrays.copyOfRange(substrings, 0, substringsSize);
    }
}