public class Agenda implements PriorityQueue {
    protected final int INIT_ARRAY_SIZE = 5;
    protected Impegno[] impegniArray;
    protected int impegniArraySize;

    // costruttore...
    Agenda() {
        impegniArray = new Impegno[5];
        makeEmpty();
    }

    // metodi pubblici (e privati)......da completare ......

    public void makeEmpty() {
        impegniArraySize = 0;
    }

    public boolean isEmpty() {
        return impegniArraySize == 0;
    }

    public void insert(int key, Object value) {
        if (!(value instanceof String))
            throw new IllegalArgumentException();
        if (impegniArray.length == impegniArraySize)
            resize();

        Impegno newImpegno = new Impegno(key, (String) value);

        impegniArraySize++;
        int i = impegniArraySize - 1;
        while (i > 0) {
            if (impegniArray[i - 1].getPriority() <= key) {
                impegniArray[i] = impegniArray[i - 1];
                i--;
            } else {
                break;
            }
        }
        impegniArray[i] = newImpegno;
    }

    public Object removeMin() throws EmptyQueueException {
        Object el = getMin();
        impegniArraySize--;
        return el;
    }

    public Object getMin() throws EmptyQueueException {
        if (impegniArraySize == 0)
            throw new EmptyQueueException();
        Object el = impegniArray[impegniArraySize - 1].getMemo();
        return el;
    }

    public String toString() {
        String output = "";
        for (int i = impegniArraySize - 1; i >= 0; i--) {
            output += impegniArray[i] + "\n";
        }
        return output;
    } // ..... da completare .........

    // campi di esemplare ..... da completare ......

    /*
     * classe privata Impegno: rappresenta gli elementi della classe Agenda ed
     * e` costituita da coppie "chiave valore" in cui il campo chiave e` di
     * tipo int e rappresenta la priorita` dell'impegno, e il campo valore e`
     * una stringa contenente un promemoria dell'impegno. Si considerano 4
     * livelli di priorita`, numerati da 0 a 3. Conseguentemente il campo
     * chiave puo` assumere valori solo in questo intervallo, dove il valore 0
     * significa "massima priorita`" e il valore 3 significa "minima priorita`"
     */
    private class Impegno // non modificare!!
    {
        public Impegno(int priority, String memo) {
            // gestione di priorità invalida
            if ((priority > 3) || (priority < 0)) {
                throw new NumberFormatException();
            }

            // gestione memo vuoto non valido
            if (memo.length() <= 0) {
                throw new IllegalArgumentException();
            }

            this.priority = priority;
            this.memo = memo;
        }

        // metodi (pubblici) di accesso
        public int getPriority() {
            return priority;

        }

        public Object getMemo() {
            return memo;
        }

        // metodo toString sovrascritto
        public String toString() {
            return priority + " " + memo;
        }

        // campi di esemplare (privati) della classe Impegno
        private int priority; // priorita` dell'impegno (da 0 a 3)
        private String memo; // promemoria dell'impegno
    }

    private void resize() {
        Impegno[] rezizedImpegniArray = new Impegno[impegniArray.length * 2];
        System.arraycopy(impegniArray, 0, rezizedImpegniArray, 0, impegniArray.length);
        impegniArray = rezizedImpegniArray;
    }
}