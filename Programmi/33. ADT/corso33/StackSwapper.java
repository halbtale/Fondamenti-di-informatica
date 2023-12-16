package corso33;

public class StackSwapper {
    public static void main(String[] args) {
        Stack s = new FixedArrayStack();
        s.push("Pippo");
        s.push("Pluto");
        s.push("Paperino");
        printAndClear(s);
        System.out.println();
        s.push("Pippo");
        s.push("Pluto");
        s.push("Paperino");
        printAndClear(swapAndClear(s));
    }

    private static Stack swapAndClear(Stack s) {
        Stack p = new FixedArrayStack();
        while (!s.isEmpty())
            p.push(s.pop());
        return p;
    }

    private static void printAndClear(Stack s) {
        while (!s.isEmpty())
            System.out.println(s.pop());
    }
}