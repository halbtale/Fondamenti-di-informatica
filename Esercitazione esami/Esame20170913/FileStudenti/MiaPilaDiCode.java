// Alberto Heissl 2101739 postazione 10

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class MiaPilaDiCode implements PilaDiCode{
    private final static int MAX_QUEUE_SIZE = 3;
    private Stack<Queue> stack;

    public MiaPilaDiCode() {
        stack = new Stack();
    }

    // Inserisci l'oggetto nella coda che si trova in cima alla pila
	public void push(Object num) {
        if (isEmpty() || stack.peek().size() == MAX_QUEUE_SIZE) {
            stack.push(new LinkedList());
        }
        stack.peek().add(num);
    }
	
	// Restituisce ed elimina l'oggetto inserito per primo 
	// nella coda che di trova in cima alla pila
	public Object pop() {
        Object lastElement = top();
        stack.peek().remove();
        if (stack.peek().size() == 0) stack.pop();
        return lastElement;
    }
	
	// Restituisce, senza eliminarlo, l'oggetto inserito per primo 
	// nella coda che di trova in cima alla pila 
	public Object top() {
        if (isEmpty()) throw new IllegalStateException("empty");
        return stack.peek().peek();
    }

	// Restituisce il numero di elementi contenuti nella pila di code
	public int size() {
        return stack.size();
    }

	// Restituisce true se la pila di code è vuota. 
	// Restituisce false altrimenti
	public boolean isEmpty() {
        return stack.isEmpty();
    }
}