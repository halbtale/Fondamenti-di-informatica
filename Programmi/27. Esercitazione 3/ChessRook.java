public class ChessRook {
    private String currentSquare;

    private char getSquareX(String square) {
        return square.charAt(0);
    }

    private char getSquareX() {
        return getSquareX(currentSquare);
    }

    private char getSquareY(String square) {
        return square.charAt(1);
    }

    private char getSquareY() {
        return getSquareY(currentSquare);
    }

    private int getSquareXIndex(String square) {
        return (int) getSquareX(square);
    }

    private int getSquareYIndex(String square) {
        return Integer.parseInt(Character.toString(getSquareY(square)));
    }

    private int getSquareXIndex() {
        return (int) getSquareX(currentSquare);
    }

    private int getSquareYIndex() {
        return Integer.parseInt(Character.toString(getSquareY()));
    }

    /**
     * Verifica se la casa specificata e' una casa valida della scacchiera, ovvero
     * se la stringa che la definisce e' di due caratteri di cui il primo
     * appartenente all'intervallo di caratteri [a, h], il secondo all'intervallo di
     * caratteri [1, 8].
     * 
     * @param chessSquare la casa specificata
     * @return true se la casa specificata e' valida, false altrimenti
     */
    private boolean isChessValidSquare(String chessSquare) {
        int xIndex = getSquareXIndex(chessSquare);
        int yIndex = getSquareYIndex(chessSquare);

        if (xIndex >= 'a' && xIndex <= 'h' && yIndex >= 0 && yIndex <= 8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Verifica se la casa specificata e' una casa raggiungibile dalla posizione
     * attuale del Cavallo
     * 
     * @param chessSquare la casa specificata
     * @return true se la casa specificata e' raggiungibile, false altrimenti
     */
    private boolean isRockReachableSquare(String chessSquare) {
        if (!isChessValidSquare(chessSquare))
            return false;

        if (getSquareX(chessSquare) == getSquareX() || getSquareY(chessSquare) == getSquareY()) {
            return true;
        } else {
            return false;
        }
    }

    public ChessRook(String initialSquare) {
        currentSquare = initialSquare;
    }

    public void moveToSquare(String toChessSquare) {
        if (!isRockReachableSquare(toChessSquare))
            throw new IllegalArgumentException();

        currentSquare = toChessSquare;
    }

    public String toString() {
        return "Torre in " + currentSquare;
    }

}
