package corso22;

public class ChessKnight {
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
     * Inizializza la posizione del Cavallo
     * 
     * @param initialSquare la posizione iniziale del Cavallo nella scacchiera
     */
    public ChessKnight(String initialSquare) {
        this.currentSquare = initialSquare;
    }

    /**
     * Se la casa specificata e' valida e raggiungibile, sposta il Cavallo nella
     * casa specificata
     * 
     * @param toChessSquare la casa specificata
     */
    public void moveToSquare(String toChessSquare) {
        if (isKnightReachableSquare(toChessSquare)) {
            currentSquare = toChessSquare;
            System.out.println("Cavallo mosso a " + currentSquare);
        } else {
            System.out.println("Casa non raggiungibile");
        }
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
    public boolean isChessValidSquare(String chessSquare) {
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
    public boolean isKnightReachableSquare(String chessSquare) {
        if (!isChessValidSquare(chessSquare))
            return false;
        int xMove = Math.abs(getSquareXIndex() - getSquareXIndex(chessSquare));
        int yMove = Math.abs(getSquareYIndex() - getSquareYIndex(chessSquare));
        if (xMove == 2 && yMove == 1 || xMove == 1 && yMove == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * descrizione testuale nella forma "Cavallo in cr" dove cr e' la posizione del
     * Cavallo nella scacchiera.
     */
    public String toString() {
        return "Cavallo in " + currentSquare;
    }
}
