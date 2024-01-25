import java.util.Scanner;
import java.util.Stack;

public class Main
{ public static void main (String[] arg)
  { Scanner in = new Scanner(System.in);
    Stack dati = new Stack();
    while (in.hasNextLine())
      dati.push(in.nextLine());
    OS x = new OS(dati);
    x.ordina();
    while (!dati.empty())
      System.out.println(dati.pop());
  }
}
