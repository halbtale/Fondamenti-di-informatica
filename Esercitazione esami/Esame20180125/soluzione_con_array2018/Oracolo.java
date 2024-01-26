 /**
    Fondamenti di Informatica 1
    Prova pratica di programmazione 
    
    Classe Oracolo.
    
    @author S. Canazza
    @version 2018
 */
 
import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;

public class Oracolo extends D
{
  public static final String[] RISPOSTA = { "Naturalmente.",
                                            "Forse.",
                                            "Ne dubito.",
                                            "Assolutamente no.",
                                            "Certamente.",
                                            "Puoi scommetterci.",
                                            "Probabilmente no.",
                                            "Poco ma sicuro."
                                          };
  private static final String STRINGA_VUOTA = "";
  
  public Oracolo()
  {
    super();
  }

  public String rispondi(String domanda)
  {
    String vaticinio = "";
    try
    {
       vaticinio = (String)(find(domanda));
    }
    catch (NoSuchElementException e)
    {
       vaticinio =  RISPOSTA[(int)(0+(1+(RISPOSTA.length-1)-0)*Math.random())];
       insert(domanda, vaticinio);
    }

    return vaticinio;
  }

  public static void main(String[] args)
  {
    Oracolo magico = new Oracolo();

    Scanner in = new Scanner(System.in);

	boolean finito = false;
    while (!finito)
    {
      if (in.hasNextLine()) {
	      String domanda = in.nextLine();
	      if (!domanda.equals(STRINGA_VUOTA)) {
	      	System.out.println("Oracolo di Delfi, " + domanda + "\n   Risposta: " + magico.rispondi(domanda));	
	      }
	      else { finito = true; }
      }
    }

    in.close();
  }
}
