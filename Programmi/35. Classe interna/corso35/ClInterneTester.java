
public class ClInterneTester {
    public static void main(String[] args) {
        ClEsterna e = new ClEsterna();

        // ClEsterna.ClInterna obj = new ClEsterna.ClInterna(); NO!

        // ClInterna test; NO!

        ClEsterna.ClInterna i = e.metEsterno(); // posso accere al tipo se è public

        i.metInterno(); // posso farlo se public
        // i.campointerno = 1; // posso farlo solo se public
    }
}
