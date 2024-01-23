// nome e cognome del candidato, matricola, data, numero della postazione
// ALBERTO HEISSL 2101739 12/01/2024, MIO_MAC
//istruzioni di import...

import java.util.Scanner;

public class AgendaTester {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        boolean shouldPromptForCommand = true;

        Scanner in = new Scanner(System.in);

        while (shouldPromptForCommand) {
            try {
                String command = promptForCommand(in);
                if (command.equalsIgnoreCase("I")) {
                    promptToInsert(in, agenda);
                } else if (command.equalsIgnoreCase("R")) {
                    System.out.println(agenda.removeMin());
                } else if (command.equalsIgnoreCase("L")) {
                    System.out.println(agenda.getMin());
                } else if (command.equalsIgnoreCase("Q")) {
                    shouldPromptForCommand = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Il formato del numero inserito non è valido");
            } catch (EmptyQueueException e) {
                System.out.println("L'agenda è vuota. Goditi il tempo libero");
            }
        }

        in.close();
    }

    private static void promptToInsert(Scanner in, Agenda agenda) {
        System.out.println("Inserisci [priorità memo]:");
        String line = in.nextLine();
        Scanner scan = new Scanner(line);
        String priority = scan.next();
        String memo = scan.nextLine().trim();
        agenda.insert(Integer.parseInt(priority), memo);
        scan.close();
    }

    private static String promptForCommand(Scanner in) {
        System.out.println("Inserisci un comando [I/R/L/Q]: ");
        String command = in.nextLine();
        return command;
    }
}