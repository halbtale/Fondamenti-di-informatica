public class MiaPilaDiCode
{
	public MiaPilaDiCode()
	{
		code = new MiaCoda[INITSIZE];
		contatore = 0;
		code[contatore] = new MiaCoda();
	}

	// Inserisci l'oggetto nella coda che si trova in cima alla pila
	public void push(Object obj)
	{
		// System.out.println("Push - size: " + code[contatore].size());
		if(code[contatore].isFull()){
			contatore++;
			code[contatore] = new MiaCoda();
		}
		// System.out.println("Push - contatore: " + contatore);
		code[contatore].enqueue(obj);
	}
	
	// Restituisce ed elimina l'oggetto inserito per primo 
	// nella coda che di trova in cima alla pila
	public Object pop()
	{
		if(isEmpty())
			throw new EmptyStackException();
		if(code[contatore].isEmpty())
			contatore--;
		return code[contatore].dequeue();
	}
	
	// Restituisce, senza eliminarlo, l'oggetto inserito per primo 
	// nella coda che di trova in cima alla pila 
	public Object top()
	{
		if(isEmpty())
			throw new EmptyStackException();
		if(code[contatore].isEmpty())
			contatore--;
		return code[contatore].getFront();
	}

	// Restituisce il numero di elementi contenuti nella pila di code
	public int size()
	{
		return contatore * 3 + code[contatore].size();
	}

	// Restituisce true se la pila di code è vuota. 
	// Restituisce false altrimenti
	public boolean isEmpty()
	{
		if(contatore == 0 && code[contatore].isEmpty())
			return true;
		return false;
	}

	private MiaCoda[] code; 
	private int contatore;
	private static int INITSIZE = 100;
}

class EmptyStackException extends java.lang.RuntimeException{}