// OS.java -- ordina uno stack
import java.util.Stack;
public class OS 
{ 
	private Stack dati;
	public OS (Stack x) { dati = x; }
	public void ordina () 
	{ 
		Stack ordinato = new Stack();
		// si ordina per selezione
		Stack uno = new Stack();
		Stack due = new Stack();
		while (!dati.empty()) uno.push(dati.pop());
		while (!uno.empty())
		{ 
			Comparable max = (Comparable)uno.pop();
			while (!uno.empty())
			{ 
				Comparable tmp = (Comparable)uno.pop();
				if (tmp.compareTo(max) > 0)
				{ due.push(max);
					max = tmp;
				}
				else
					due.push(tmp);
			}
			dati.push(max);
			uno = due;
			due = new Stack(); 
		} 
	}
}
