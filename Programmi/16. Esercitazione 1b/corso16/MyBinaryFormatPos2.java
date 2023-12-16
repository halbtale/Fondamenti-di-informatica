package corso16;

import java.util.Scanner;

public class MyBinaryFormatPos2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Chiedi all'utente di inserire un numero
        System.out.println("Inserisci un numero negativo da -1 a -128");

        // Leggi il nuemro con lo scanner e memorizzalo in una variabile (tipo byte)
        byte numeroInserito = in.nextByte();
        byte numeroInseritoNormalizzato = (byte) (numeroInserito + 128);

        // Converti in numero binario
        byte numeroDopoIterazione1 = (byte) (numeroInseritoNormalizzato / 2);
        byte restoDopoIterazione1 = (byte) (numeroInseritoNormalizzato % 2);

        byte numeroDopoIterazione2 = (byte) (numeroDopoIterazione1 / 2);
        byte restoDopoIterazione2 = (byte) (numeroDopoIterazione1 % 2);

        byte numeroDopoIterazione3 = (byte) (numeroDopoIterazione2 / 2);
        byte restoDopoIterazione3 = (byte) (numeroDopoIterazione2 % 2);

        byte numeroDopoIterazione4 = (byte) (numeroDopoIterazione3 / 2);
        byte restoDopoIterazione4 = (byte) (numeroDopoIterazione3 % 2);

        byte numeroDopoIterazione5 = (byte) (numeroDopoIterazione4 / 2);
        byte restoDopoIterazione5 = (byte) (numeroDopoIterazione4 % 2);

        byte numeroDopoIterazione6 = (byte) (numeroDopoIterazione5 / 2);
        byte restoDopoIterazione6 = (byte) (numeroDopoIterazione5 % 2);

        byte numeroDopoIterazione7 = (byte) (numeroDopoIterazione6 / 2);
        byte restoDopoIterazione7 = (byte) (numeroDopoIterazione6 % 2);

        System.out.printf("0b%d%d%d%d_%d%d%d%d%n", 1, restoDopoIterazione7, restoDopoIterazione6, restoDopoIterazione5,
                restoDopoIterazione4, restoDopoIterazione3, restoDopoIterazione2, restoDopoIterazione1);

        in.close();
    }
}
