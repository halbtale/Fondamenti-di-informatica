public class ChessKing {
    private char row;
    private char col;

    final char MIN_COL = 'a';
    final char MAX_COL = 'h';
    final char MIN_RAW = '1';
    final char MAX_RAW = '8';

    public ChessKing(String initialSquare) {
        if (!isChessValidSquare(initialSquare))
            throw new IllegalArgumentException();

        row = initialSquare.charAt(0);
        col = initialSquare.charAt(1);
    }

    private boolean isChessValidSquare(String chessSquare) {
        final char MIN_COL = 'a';
        final char MAX_COL = 'h';
        final char MIN_RAW = '1';
        final char MAX_RAW = '8';

        return chessSquare.length() == 2 // la stringa della casa ha due caratteri
                && chessSquare.charAt(0) >= MIN_COL // il primo carattere e' compreso
                && chessSquare.charAt(0) <= MAX_COL // nell'intervallo [MIN_COL, MAX_COL]
                && chessSquare.charAt(1) >= MIN_RAW // il secondo carattere e' compreso
                && chessSquare.charAt(1) <= MAX_RAW;// nell'intervallo [MIN_ROW, MAX_ROW]
    }

    private boolean isKingReachableSquare(String toChessSquare) {
        char newRow = toChessSquare.charAt(0);
        char newCol = toChessSquare.charAt(1);

        if (Math.abs(row - newRow) <= 1 && Math.abs(col - newCol) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public void moveToSquare(String toChessSquare) {
        if (!isKingReachableSquare(toChessSquare))
            throw new IllegalArgumentException();

        row = toChessSquare.charAt(0);
        col = toChessSquare.charAt(1);
    }

    public String toString() {
        return "Il rè si trova in " + row + col;
    }

}
