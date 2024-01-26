 /**
    Fondamenti di Informatica 1
    Prova pratica di programmazione
    
    Classe Oracolo.
    
    @author S. Canazza
    @version 2018

-----------------------------------------------------
*****************************************************
--- NOME: Alberto 
--- COGNOME: Heissl
--- MATRICOLA: 2101739
--- POSTAZIONE: 10
*****************************************************
-----------------------------------------------------

*/
import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;

public class Oracolo extends D
{
  public static final String[] RISPOSTA = { 
    "Naturalmente.",
    "Forse.",
    "Ne dubito.",
    "Assolutamente no.",
    "Certamente.",
    "Puoi scommetterci.",
    "Probabilmente no.",
    "Poco ma sicuro."
  };
  private static final String STRINGA_VUOTA = "";

  public String rispondi(String domanda) {
    if (domanda.equals(STRINGA_VUOTA)) return "Non ho capito la domanda, puoi ripetere?";
    try {
      String rispostaTrovata = (String) super.find(domanda);
      return rispostaTrovata;
    } catch (NoSuchElementException e) {
      String rispostaInventata = generaRispostaCasuale();
      super.insert(domanda, rispostaInventata);
      return rispostaInventata;
    }
  }

  private String generaRispostaCasuale() {
    int A = 0;
    int B = RISPOSTA.length;
    return RISPOSTA[(int)(A+(1+B-A)*Math.random())];
  }

  public static void main(String[] args) { 
    Oracolo oracolo = new Oracolo();
    try (Scanner scan = new Scanner(System.in)) {
      while (scan.hasNextLine()) {
        String domanda = scan.nextLine();
        if (!domanda.equals(STRINGA_VUOTA)) {
          System.out.println(oracolo.rispondi(domanda));
        }
      }
    }
  }
  
}
