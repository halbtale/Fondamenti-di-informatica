
import java.util.Scanner;

/**
 * Memorizza un testo suddiviso in righe. Contiene un numero indefinito di
 * righe.
 * Fornisce un insieme di primitive per elaborare il testo. Le righe sono
 * stringhe terminate con caratteri di fine riga, quali LF (line feed '\r') o CR
 * (carrige return '\n') o LF+CR ("\r\n") Le parole sono token separati da
 * caratteri whitespaces (consultare il metodo predicativo
 * java.lang.Character.isWhitespace(char c))
 */
public class MyWordProcessor {
    final int DEFAULT_ARRAY_SIZE = 10;

    private String[] lineArray;
    private int lineArraySize;

    /*
     * inizializza un testo vuoto
     */
    public MyWordProcessor() {
        lineArray = new String[DEFAULT_ARRAY_SIZE];
        lineArraySize = 0;
    }

    /**
     * aggiunge una riga in coda a questo testo
     * 
     * @param line - la riga da aggiungere in coda a questo testo
     */
    public void add(String line) {
        if (lineArray.length > (lineArraySize + 1)) {
            lineArray[lineArraySize] = line;
            lineArraySize++;
        } else {
            lineArray = MyWordProcessor.resize(lineArray, lineArray.length * 2);
            lineArray[lineArraySize] = line;
            lineArraySize++;
        }
    }

    /**
     * suddivide questo testo in parole (tokens), mantenendo alterata la sequenza
     * delle parole
     * 
     * @return array contenente le parole di questo testo nella sequenza in cui
     *         compaiono nel testo
     */
    public String[] toWords() {
        String[] words = new String[DEFAULT_ARRAY_SIZE];
        int wordsSize = 0;

        for (int i = 0; i < lineArraySize; i++) {
            String currentLine = lineArray[i];
            Scanner scan = new Scanner(currentLine);

            while (scan.hasNext()) {
                String word = scan.next();

                if (words.length > (wordsSize + 1)) {
                    words[wordsSize] = word;
                    wordsSize++;
                } else {
                    words = MyWordProcessor.resize(words, words.length * 2);
                    words[wordsSize] = word;
                    wordsSize++;
                }
            }

            scan.close();
        }

        return MyWordProcessor.resize(words, wordsSize);
    }

    /**
     * ricerca la parola specificata da sostituire (find) e la sostituisce con la
     * parola specificata per la sostituzione (replace). Tutte le occorrenze della
     * parola specificata find sono sostituite con la parola specificata replace
     * 
     * @param find    la parola specificata da trovare e sostituire
     * @param replace la parola specificata usata nella sostituzione
     * @return numero di sostituzioni effettuate
     */
    public int findAndReplace(String find, String replace) {
        int substitutions = 0;
        for (int i = 0; i < lineArraySize; i++) {
            String currentLine = lineArray[i];
            String newLine = "";
            Scanner scan = new Scanner(currentLine);

            while (scan.hasNext()) {
                String word = scan.next();

                if (!word.equals(find)) {
                    newLine = newLine + word + " ";
                } else {
                    newLine = newLine + replace + " ";
                    substitutions++;
                }
            }

            lineArray[i] = newLine;

            scan.close();
        }

        return substitutions;
    }

    /**
     * restituisce la parola massima di questo testo, massima in senso
     * lessicografico
     * 
     * @return la parola massima di questo testo in senso lessicografico
     */
    public String maxString() {
        String[] words = toWords();
        String maxWordFound = words[0];

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (currentWord == null)
                break;

            if (currentWord.compareTo(maxWordFound) > 0) {
                maxWordFound = currentWord;
            }
        }

        return maxWordFound;
    }

    /**
     * restituisce la descrizione testuale di questo testo, una riga alla volta,
     * nella sequenza in cui le righe sono disposte in questo testo
     * 
     */
    public String toString() {
        String text = "";
        for (int i = 0; i < lineArraySize; i++) {
            String currentLine = lineArray[i];
            if (text.length() > 0)
                text = text + "\n";
            text = text + currentLine;
        }
        return text;
    }

    /**
     * restituisce il numero di parole di questo testo
     * 
     * @return il numero di parole di questo testo
     */
    public int wordSize() {
        return toWords().length;
    }

    /**
     * 
     * restituisce il numero di righe di questo testo
     * 
     * @return il numero di righe di questo testo
     * 
     */
    public int size() {
        return lineArraySize;
    }

    public static String[] resize(String[] oldArray, int newLength) {
        if (newLength < 0 || oldArray == null)
            throw new IllegalArgumentException();

        String[] newArray = new String[newLength];
        int n = Math.min(oldArray.length, newLength);

        for (int i = 0; i < n; i++)
            newArray[i] = oldArray[i];

        return newArray;
    }

}
