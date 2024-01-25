/*
Esercizio: ordinare elementi di una pila
Premessa1: l'algoritmo di ordinamento è ben conosciuto
Premessa2: l'ADT Stack è ben conosciuto
Esercizio: realizzare l’ordinamento per fusione (Mergesort) applicato a una pila anziché, come visto a lezione, a un array
(ovviamente la pila deve contenere oggetti Comparable)
Il file di output deve contenere gli oggetti dal minore al maggiore.
Il primo problema consiste nella suddivisione della pila in due pile di dimensioni circa uguali:
Ma non si conosce la dimensione della pila.
Suggerimento (soluzione semplice): estrarre gli elementi dalla pila e inserirli alternativamente in due semi-pile
*/

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;


public class Ordine
/*
Da notare:
La fase di lettura: si legge una riga per volta dal file input.txt (usare reinderizzamento dell'input), usando lo Scanner in, e poi dentro la riga si scandiscono le singole parole usando lo Scanner sc.
La fase di estrazione e stampa degli elementi della pila: gli oggetti devono di volta in volta venire estratti per essere stampati, dal momento che solo l'oggetto in cima alla pila puo` essere ispezionato. 
ATTENZIONE: in questo modo i token vengono scritti nel file in ordine inverso rispetto a quello con cui sono stati inseriti nella pila
La gestione delle eccezioni di IO è NON ottimale: in effetti non sono prorpio gestite, e il metodo main dichiara nella propria firma che le propaga.
*/
{

public static void main(String[] args) throws IOException

	{
        if (args.length != 1) //controllo che da riga di comando sia
        {                     //stata passata esattamente una stringa
            System.out.println("uso: $java StackTester outFile");
            System.exit(1);
        }
      
        // Inserimento elementi da file nella pila
        Scanner in = new Scanner(System.in);
        Stack pila = new GrowingArrayStack();
        while (in.hasNextLine())
        {  Scanner sc = new Scanner(in.nextLine());
            while (sc.hasNext())
            {   String token = sc.next();
                pila.push(token);
            }
        }
        in.close();
      
        mergeSort(pila);

        // Svuotamento della pila, e scrittura su file
        PrintWriter writer1 = new PrintWriter(args[0]);

        while (!pila.isEmpty())
            writer1.println((String)pila.pop()); 
        writer1.close();
    }



public static void mergeSort(Stack s)
{ 
	if (s == null || s.isEmpty()) return; // caso base
	Object temp = s.pop();
	if (s.isEmpty())
	{  s.push(temp); // altro caso base: dimensione 1
	return; }

// dividiamo (circa) a meta’
   Stack left = new GrowingArrayStack();
   Stack right = new GrowingArrayStack();
   left.push(temp);
   boolean flag = true;
   while (!s.isEmpty())
   {  if (flag)
         right.push(s.pop());
      else
         left.push(s.pop());
      flag = !flag; 
   }
   mergeSort(left);
   mergeSort(right);
   // fusione: si osservi che s è rimasta vuota
   merge(s, left, right);
}

 private static void merge(Stack s,
                          Stack left, Stack right)
{  Stack temp = new GrowingArrayStack();
   while (!left.isEmpty() && !right.isEmpty())
   {  Comparable x = (Comparable) left.top();
      Comparable y = (Comparable) right.top();
      if (x.compareTo(y) < 0)
         temp.push(left.pop());
      else temp.push(right.pop());
   }
   	while (!left.isEmpty())
      temp.push(left.pop());
   	while (!right.isEmpty())
      temp.push(right.pop());
	while (!temp.isEmpty())  // inverte il contenuto
   	s.push(temp.pop());
}
 

}