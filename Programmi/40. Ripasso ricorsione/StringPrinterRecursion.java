public class StringPrinterREcursion {
    public static void printSubstring(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) System.out.println(s);
        else {
            for (int i = 1; i <= s.length(); i++) {
                System.out.println(s.substring(0, i));
            }
            printSubstring(s.substring(1));
        }
    }
}