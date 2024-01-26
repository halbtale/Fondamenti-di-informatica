// Main.java -- prova di MiaCD

import java.io.*;
import java.util.Scanner;

public class Main
{ public static void main (String[] arg) throws java.io.IOException
  { Scanner in = new Scanner(System.in);
    MiaCD uno = new MiaCD();
    MiaCD due = new MiaCD();
    MiaCD tre = new MiaCD();
    while (in.hasNext())
      uno.addLast(in.nextLine());
    while (uno.size() > 0)
      due.addFirst(uno.removeLast());
    while (!due.isEmpty())
      tre.addLast(due.removeFirst());
    while (!tre.isEmpty())
      System.out.println(tre.removeFirst());
    if (!uno.isEmpty() || !due.isEmpty() || !tre.isEmpty()) System.err.println("Errore");
  }
}
