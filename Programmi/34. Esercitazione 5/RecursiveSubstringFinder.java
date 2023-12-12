class RecursiveSubstringFinder {
    public static void main(String[] args) {
        String s = "Ciao";
        String sub = "ao";

        int startIndex = recursiveSubstringFinder(s, sub);
        System.out.println(startIndex);
    }

    public static int recursiveSubstringFinder(String s, String sub) {
        if (s.length() < sub.length())
            return -1;
        if (s.substring(0, sub.length()).equals(sub)) {
            return 0;
        } else {
            return recursiveSubstringFinder(s.substring(1), sub) + 1;
        }
    }
}