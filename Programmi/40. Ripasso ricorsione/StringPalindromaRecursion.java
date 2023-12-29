public class StringPalindromaRecursion {
    public static boolean isPalindroma(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindroma(s.substring(1, s.length() - 1));
    }
}