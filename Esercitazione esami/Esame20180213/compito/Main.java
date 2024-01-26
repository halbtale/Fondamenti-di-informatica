import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CD uno = new MiaCD();
        CD due = new MiaCD();
        CD tre = new MiaCD();

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                uno.addLast(in.nextLine());
            }
            while (!uno.isEmpty()) {
                due.addFirst(uno.removeLast());
            }
            while (!due.isEmpty()) {
                tre.addLast(due.removeFirst());
            }
            while (!tre.isEmpty()) {
                System.out.println(tre.removeFirst());
            }
        }
    }
}