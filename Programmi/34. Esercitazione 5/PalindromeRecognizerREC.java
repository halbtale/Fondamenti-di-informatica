public class PalindromeRecognizerREC {
    public static void main(String[] args) {
        String givenString = args[0];

        if (isPalindromeREC(givenString)) {
            System.out.println("Palindroma");
        } else {
            System.out.println("Non palindroma");
        }
    }

    public static boolean isPalindromeREC(String s) {
        if (s.length() <= 1) {
            return true;
        } else if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        } else {
            return isPalindromeREC(s.substring(1, s.length() - 1));
        }
    }
}
