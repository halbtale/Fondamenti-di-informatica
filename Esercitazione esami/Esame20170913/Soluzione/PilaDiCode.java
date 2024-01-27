// Interfaccia che definisce una Pila di Code - PilaDiCode.java
public interface PilaDiCode 
{
	// Inserisci l'oggetto nella coda che si trova in cima alla pila
	void push(Object num);
	
	// Restituisce ed elimina l'oggetto inserito per primo 
	// nella coda che di trova in cima alla pila
	Object pop();
	
	// Restituisce, senza eliminarlo, l'oggetto inserito per primo 
	// nella coda che di trova in cima alla pila 
	Object top();

	// Restituisce il numero di elementi contenuti nella pila di code
	int size();

	// Restituisce true se la pila di code è vuota. 
	// Restituisce false altrimenti
	boolean isEmpty();
}