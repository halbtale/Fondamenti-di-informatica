public class StringRevRecursion {
    public static String rev(String s) {
        if (s == null) return null;
        if (s.length() < 2) return s;

        return rev(s.substring(1)) + s.charAt(0);
    }
}