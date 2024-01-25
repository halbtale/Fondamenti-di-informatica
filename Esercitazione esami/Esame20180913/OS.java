// Alberto Heissl 2101739 Postazione10

// OS.java -- Ordina Stack
import java.util.Stack;

@SuppressWarnings("unchecked")
public class OS
{
	private Stack s;

	public OS (Stack x) { 
		s = x;
	}

	// algoritmo merge sort
	public void ordina () {  
		mergeSort(s);
	}

	private void mergeSort(Stack s) {
		if (s == null || s.isEmpty()) return;

		Stack s1 = new Stack();
		Stack s2 = new Stack();
		int counter = 0;

		while (!s.isEmpty()) {
			if (counter % 2 == 0) {
				s1.push(s.pop());
			} else {
				s2.push(s.pop());
			}
			counter++;
		}

		if (s2.isEmpty()) {
			s.push(s1.pop());
			return;
		}

		mergeSort(s1);
		mergeSort(s2);

		merge(s, s1, s2);
	}

	private void merge(Stack s, Stack s1, Stack s2) {
		Stack tempS = new Stack();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (((Comparable) s1.peek()).compareTo(s2.peek()) < 0) {
				tempS.push(s1.pop());
			} else {
				tempS.push(s2.pop());
			}
		}

		while (!s1.isEmpty()) {
			tempS.push(s1.pop());
		}

		while (!s2.isEmpty()) {
			tempS.push(s2.pop());
		}

		while (!tempS.isEmpty()) {
			s.push(tempS.pop());
		}
	}
}
