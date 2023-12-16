package corso34;

public class PalindromeRecognizerIT {
    public static void main(String[] args) {
        String givenString = args[0];

        if (isPalindromeIt(givenString)) {
            System.out.println("Palindroma");
        } else {
            System.out.println("Non palindroma");
        }
    }

    public static boolean isPalindromeIt(String s) {
        boolean isPalindrome = true;
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                isPalindrome = false;
            }
        }
        return isPalindrome;
    }
}
