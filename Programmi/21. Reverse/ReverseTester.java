import java.util.Scanner;

public class ReverseTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire una stringa: ");
        String s = in.nextLine();
        String r = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            r = ch + r;
        }
        System.out.printf("%s invertita è %s%n", s, r);
    }
}
