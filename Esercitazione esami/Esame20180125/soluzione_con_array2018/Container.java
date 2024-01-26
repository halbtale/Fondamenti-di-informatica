 /**
    Fondamenti di Informatica 1
    Prova pratica di programmazione
    
    Interfaccia Container

    @author S. Canazza
    @version 2018
 */
 
public interface Container
{
	/** Restituisce true se il contenitore e' vuoto, false altrimenti. */
	boolean isEmpty();
	
	/** Rende vuoto il contenitore. */
	void makeEmpty();
	
	/** Restituisce il numero di elementi inseriti nel contenitore. */
	int size();
}
