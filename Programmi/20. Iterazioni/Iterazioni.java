public class Iterazioni {
    public static void main(String[] args) {
        // stampo tutti i valori di x^y
        final int MAX_X = 4;
        final int MAX_Y = 5;
        final int COLUMN_WIDTH = 6;

        for (int x = 1; x <= MAX_X; x++) {
            for (int y = 1; y <= MAX_Y; y++) {
                String p = Integer.toString((int) Math.round(Math.pow(x, y)));

                while (p.length() < COLUMN_WIDTH) {
                    p = " " + p;
                }

                System.out.print(p);
            }
            System.out.println();
        }
    }
}
