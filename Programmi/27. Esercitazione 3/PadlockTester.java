/**
 * Classe di prova della classe Padlock
 * 
 * @author A. Luchetta
 * @version 20201027
 * 
 */
public class PadlockTester {
    public static void main(String[] args) {
        final String PASSWD1 = "APRITI_SESAMO";
        final String PASSWD2 = "RIAPRITI_SESAMO";

        Padlock p = new Padlock(PASSWD1);
        System.out.println(p);

        p.close();
        System.out.println(p);

        p.open(PASSWD2);
        System.out.println(p);

        p.open(PASSWD1);
        System.out.println(p);

        p.setPasswd(PASSWD1, PASSWD2);

        p.open(PASSWD2);
        System.out.println(p);
    }
}