// nome e cognome del candidato, matricola, data, numero della postazione

import java.util.Scanner;
import java.util.NoSuchElementException;

public class MultiQueueTester {
	private static final String ANSI_RESET = "\u001B[0m";
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_GREEN = "\u001B[32m";
	private static final String ANSI_YELLOW = "\u001B[33m";

  public static void main(String[] args) {
    int N = getNFromArgs(args);
    
    MultiQueue multiQueue = new ArrayMultiQueue(N);

    boolean shouldPromptForCommand = true;

	Scanner in = new Scanner(System.in);

    while (shouldPromptForCommand) {
		System.out.println("\nInsert a command");
		if (!in.hasNextLine()) break;
		String command = in.nextLine();

		if (command.equalsIgnoreCase("A")) {
			addAction(in, multiQueue);
		} else if (command.equalsIgnoreCase("R")) {
			removeAction(in, multiQueue);
		} else if (command.equalsIgnoreCase("P")) {
			System.out.println(ANSI_GREEN + multiQueue + ANSI_RESET);
		} else if (command.equalsIgnoreCase("Q")) {
			shouldPromptForCommand = false;
		}
    }

	in.close();
  } 

  private static int getNFromArgs(String[] args) {
    try {
      if (args.length != 1) {
        throw new IllegalArgumentException();
      }
      int N = Integer.parseInt(args[0]);
	  if (N <= 0) throw new IllegalArgumentException();
      return N;
    } catch (RuntimeException e) {
      System.err.println(ANSI_RED + "Usage: java MultiQueueTester [N>0]" + ANSI_RESET);
      System.exit(1);
    }
	return -1;
  }

  private static void addAction(Scanner in, MultiQueue q) {
	try {
		System.out.println("Please insert the name of the new person");
		String name = in.nextLine();
		q.add(name);
		System.out.println(ANSI_GREEN + name + " added successfully" + ANSI_RESET);
	} catch (NoSuchElementException e) {
		System.err.println(ANSI_YELLOW + "No input found" + ANSI_RESET);
	}
  }

  private static void removeAction(Scanner in, MultiQueue q) {
	try {
		System.out.println("Please insert the index of the queue");
		String input = in.nextLine();
		int index = Integer.parseInt(input);
		Object removedElement = q.remove(index);
		System.out.println(ANSI_GREEN + "Successfully removed element:" + ANSI_RESET);
		System.out.println(removedElement);
	} catch (NoSuchElementException e) {
		System.err.println(ANSI_YELLOW + "No input found" + ANSI_RESET);
	} catch (NumberFormatException e) {
		System.err.println(ANSI_YELLOW + "The format of the number is not valid" + ANSI_RESET);
	} catch (EmptyQueueException e) {
		System.err.println(ANSI_YELLOW + "The queue selected is empty" + ANSI_RESET);
	}
  }
}
