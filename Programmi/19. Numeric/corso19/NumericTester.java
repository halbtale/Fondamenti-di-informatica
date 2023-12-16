
public class NumericTester {
    public static void main(String[] args) {
        double r = Math.sqrt(2);
        if (Numeric.approxEqual(r * r, 2)) {
            System.out.println("Tutto bene..");
        } else {
            System.out.println("What?");
        }
    }
}
