// Nome:
// Cognome: 
// Matricola:
// Postazione:
// 23 Febbraio 2023
// MI RITIRO DALL'ESAME: NO

/* Il metodo ausiliario removeDuplicates realizza la rimozione di duplicati usando due pile temporanee, mentre il metodo removeDuplicates_b risolve il problema usando una sola pila temporanea. Entrambi i metodi però realizzano sostanzialmente lo stesso algoritmo:
- si svuota tutta la pila di partenza, memorizzandone gli elementi in una pila temporanea
- si estrae il primo elemento della pila temporanea, e lo si riscrive nella pila di partenza
- si elimina dalla pila temporanea tutti i doppioni di questo elemento; a tal fine:
- si svuota la pila temporanea e si confronta ogni elemento estratto con quello in esame
- si scartano tutti i doppioni dell'elemento in esame
- si re-inseriscono nella pila temporanea tutti gli elementi non scartati
- si ripetono i passi 2 e 3 finche` la pila temporanea non è vuota
- L'unica differenza tra le due realizzazioni è che nella soluzione "a" si usa una seconda pila temporanea durante il passo 3 per memorizzare gli elementi che non sono duplicati dell'elemento in esame, mentre nella soluzione "b" si usa come spazio temporaneo la stessa pila s, e per distinguere elementi definitivi e temporanei in s si conta quanti elementi temporanei vengono inseriti
*/

import java.util.Scanner;

public class RimuoveDoppioni
{   public static void main(String[] args)
    {   //controllo parametro passato sulla riga di comando: se vale "a" uso la
        //soluzione che impiega 2 pile temporanee, se vale "b" uso la soluzione
        //che impiega 1 pila temporanea
        if (args.length != 1 || !(args[0].equals("a") || args[0].equals("b")))
        {   System.out.println("Uso: $java RimuoveDoppioni < arg >");
            System.out.println("Se arg = \"a\" si usa soluzione a (2 pile)");
            System.out.println("Se arg = \"b\" si usa soluzione b (1 pila)");
            System.exit(1);
        }

        //Creo una pila e vi inserisco numeri interi letti da standard input 
        Scanner in = new Scanner(System.in);
        Stack stack = new ArrayStack();    
        while (in.hasNextLine())
        {   Scanner linescan = new Scanner(in.nextLine());
            while (linescan.hasNext())
            {   try{
                    stack.push(new Integer(Integer.parseInt(linescan.next())));
                    }
                catch(NumberFormatException e) {} // Se vengono inseriti dati
            }                                     // non numerici, li ignoro
        }

        //effettuo la rimozione dei duplicati
        if (args[0].equals("a"))   removeDuplicates_a(stack);
        else                       removeDuplicates_b(stack);
        System.out.println("\n*** Pila senza doppioni ***");
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }

    //metodo statico ausiliario: rimuove duplicati usando 2 pile temporanee
    public static void removeDuplicates_a(Stack s)
    {   // uso due pile temporanee
        Stack temp1 = new ArrayStack();
        Stack temp2 = new ArrayStack();

        /* 
          copio la pila s in temp1, che conterra` sempre gli elementi ancora 
          da esaminare: s viene quindi svuotata. Successivamente, s conterra`
          in ogni momento gli elementi gia` esaminati e che non hanno duplicati
        */
        while (!s.isEmpty())
            temp1.push(s.pop());

        /*
            all'inizio di ogni iterazione di questo ciclo s contiene solo
            elementi che sicuramente non hanno duplicati (prima della prima  
            iterazione s e' vuota), mentre temp1 contiene un insieme di elementi 
            con potenziali duplicati; quando temp1 e' vuota l'algoritmo termina
        */    
        while (!temp1.isEmpty())
        {   /* 
                sicuramente il primo elemento di temp1 non e` gia` in s, 
                quindi lo inserisco in s; ora dovro` eliminare da temp1
                tutti gli eventuali duplicati di tale elemento
            */
            Object obj = temp1.pop();
            s.push(obj);
            /*
                elimino tutti gli eventuali duplicati di obj in temp1. Ovvero 
                estraggo tutti gli elementi da temp1 e li confronto con obj: se 
                un elemento *non* e` un duplicato di obj, lo inserisco nella
                seconda pila temporanea, altrimenti me ne posso "dimenticare"
            */
            while(!temp1.isEmpty())
            {   Object obj2 = temp1.pop();
                if (!obj.equals(obj2)) temp2.push(obj2);
            }
            /*
                ri-trasferisco tutti gli elementi da temp2 a temp1, perche` tali
                elementi dovranno essere esaminati di nuovo. Ora temp1 contiene
                tutti gli elementi di s che non sono duplicati di obj.
            */
            while (!temp2.isEmpty())
                temp1.push(temp2.pop());
            /*
                Oppure, in maniera equivalente:
                Stack temp3 = temp1; temp1 = temp2; temp2 = temp3;
            */
        }
    }

    //metodo statico ausiliario: rimuove duplicati usando 1 pila temporanea
    public static void removeDuplicates_b(Stack s)
    {   // uso una pila temporanea
        Stack temp = new ArrayStack();

        // copio s in temp; s sara` quindi vuota al termine di questo ciclo
        while (!s.isEmpty())
            temp.push(s.pop());

        /*
            all'inizio di ogni iterazione di questo ciclo s contiene solo
            elementi che sicuramente non hanno duplicati (prima della prima  
            iterazione s e' vuota), mentre temp contiene un insieme di elementi 
            con potenziali duplicati; quando temp e' vuota l'algoritmo termina
        */    
        while (!temp.isEmpty())
        {  /*
                sicuramente il primo elemento di temp non e` gia` in s, 
                quindi lo inserisco in s; ora dovro` eliminare da temp
                tutti gli eventuali duplicati di tale elemento
            */
            Object obj = temp.pop();
            s.push(obj);
            /*
                ora devo estrarre da temp tutti i suoi elementi e reinsere solo 
                quelli che non sono duplicati di obj; nella soluzione "a" usavo
                un'altra pila, qui uso come spazio temporaneo la stessa pila s;
                per distinguere elementi definitivi e temporanei in s, conto
                quanti elementi temporanei inserisco
            */
            int count = 0;
            while(!temp.isEmpty())
            {   Object obj2 = temp.pop();
                if (!obj.equals(obj2))
                {   s.push(obj2);
                    count++;
                }
            }
            /*
                rimetto in temp gli elementi temporanei appena inseriti in s, 
                per esaminarli alla prossima iterazione del ciclo principale
            */
            while (count-- > 0)
                temp.push(s.pop());
        }
    }  
}