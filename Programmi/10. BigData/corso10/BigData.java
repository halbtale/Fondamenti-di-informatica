package corso10;

import java.math.BigInteger;

public class BigData {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("999999999999999999999999999999999999999999999999999999999999");
        BigInteger b = a.pow(100);
        System.out.println(b);
    }
}
