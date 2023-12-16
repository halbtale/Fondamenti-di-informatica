
public class TerminalTester {
    public static void main(String[] args) {
        String cParam = "";
        for (int i = 0; i < args.length; i++) {
            String currentArg = args[i];

            if (currentArg.startsWith("-")) {
                if (currentArg.equals("-c")) {
                    cParam = args[i + 1];
                }
            }
        }
        System.out.println(cParam);
    }
}
