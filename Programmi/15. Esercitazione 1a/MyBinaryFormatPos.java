import java.util.Scanner;

public class MyBinaryFormatPos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Chiedi all'utente di inserire un numero
        System.out.println("Inserisci un numero positivo da 0 a 127");

        // Leggi il nuemro con lo scanner e memorizzalo in una variabile (tipo byte)
        byte numeroInserito = in.nextByte();

        // Converti in numero binario
        byte numeroDopoIterazione1 = (byte) (numeroInserito / 2);
        byte restoDopoIterazione1 = (byte) (numeroInserito % 2);

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

        // Mostra risultato
        System.out.print("0b");
        System.out.print(0);
        System.out.print(restoDopoIterazione7);
        System.out.print(restoDopoIterazione6);
        System.out.print(restoDopoIterazione5);
        System.out.print("_");
        System.out.print(restoDopoIterazione4);
        System.out.print(restoDopoIterazione3);
        System.out.print(restoDopoIterazione2);
        System.out.println(restoDopoIterazione1);

        in.close();
    }
}
