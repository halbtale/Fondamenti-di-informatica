class Agenda implements PriorityQueue {
    // costruttore...

    // metodi pubblici (e privati)......da completare ......

    public String toString() {
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
}