// Nome: Alberto
// Cognome: Heissl
// Matricola: 2101739
// Postazione: 10
// 23 Febbraio 2023
// MI RITIRO DALL'ESAME: NO


import java.util.Scanner;

public class RimuoveDoppioni
{   
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {   
        Scanner in = new Scanner(System.in);
        Stack s = new ArrayStack();

        while (in.hasNext()) {
            try {
                int n = Integer.parseInt(in.next());
                s.push(n);
            } catch (NumberFormatException e) {
                System.err.println(ANSI_YELLOW + "Formato del numero inserito non valido" + ANSI_RESET);
            }
        }

        in.close();

        removeDuplicates(s);

        if (s.isEmpty()) {
            System.err.println(ANSI_YELLOW + "La pila inserita e' vuota" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "Il risultato è: " + ANSI_RESET);
            while (!s.isEmpty()) {
                System.out.println(s.pop());
            }
        }
    }  

    private static void removeDuplicates(Stack s) {
        Stack tempS = new ArrayStack();

        int elementToCheckIndex = 0;
        boolean shouldLoop = true;

        while (shouldLoop) {
            Object elementToCheck = null;
            int i = 0;

            while (!s.isEmpty()) {
                Object currentElement = s.pop();
                if (i == elementToCheckIndex) {
                    elementToCheck = currentElement;
                    tempS.push(currentElement);
                }
                if (elementToCheck == null || !elementToCheck.equals(currentElement)) {
                    tempS.push(currentElement);
                }

                i++;
            }

            if (elementToCheck == null) {
                shouldLoop = false;
            }

            while (!tempS.isEmpty()) {
                s.push(tempS.pop());
            }

            elementToCheckIndex++;
        }
    }
}