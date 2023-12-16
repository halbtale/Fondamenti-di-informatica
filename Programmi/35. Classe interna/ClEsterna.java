public class ClEsterna { // metodi della classe esterna
    public ClInterna metEsterno() {
        ClInterna obj = new ClInterna(); // LECITO
        obj.campointerno = 2;// LECITO: anche se il campo e`
        return obj; // privato in ClInterna
    }

    // campi di esemplare della classe esterna
    private double campoEsterno;

    // definizione di classe interna

    public class ClInterna // puo` anche essere private!
    {
        // metodi della classe interna
        public void metInterno() {
            ClEsterna obj = new ClEsterna(); // LECITO
            double a = campoEsterno; // LECITO: anche se il campo e` privato in ClEsterna
        }

        // campi di esemplare della classe interna

        private int campointerno;
    }
}