// Alberto Heissl 2101739 Postazione10

import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class Main
{ 
	public static void main(String[] args)
	{ 
		Scanner in = new Scanner(System.in);
		Stack s = new Stack();

		while (in.hasNextLine()) {
			String line = in.nextLine();
			s.push(line);
		}

		OS os = new OS(s);
		os.ordina();

		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}

		in.close();
	}
}
