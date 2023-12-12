public class MontyHallTester {
    public static void main(String[] args) {
        if (args[0] == null)
            throw new IllegalArgumentException();

        int iterations = Integer.parseInt(args[0]);
        int winCount = 0;
        int keepWinCount = 0;
        int changeWinCount = 0;

        for (int i = 0; i < iterations; i++) {
            boolean[] result = play();
            if (result[0]) {
                winCount++;

                if (result[1]) {
                    changeWinCount++;
                } else {
                    keepWinCount++;
                }
            }
        }

        double winFrequency = (double) winCount / (iterations);
        double winKeepFrequency = (double) keepWinCount / (winCount);
        double winChangeFrequency = (double) changeWinCount / (winCount);

        System.out.println(winCount);
        System.out.println(keepWinCount);
        System.out.println(changeWinCount);

        System.out.println("frequaenza di vittoria:                    " + winFrequency);
        System.out.println("frequenza in caso di conferma della scelta:" + winKeepFrequency);
        System.out.println("frequenza in caso di modifica della scelta:" + winChangeFrequency);

    }

    private static boolean[] play() {
        MontyHall game = new MontyHall();
        game.setFirstChoice();
        game.openGoatDoor();
        game.setSecondChoice();
        boolean[] result = { game.victory(), game.hadChanged() };
        return result;
    }
}