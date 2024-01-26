 /**
    Fondamenti di Informatica Canale 1
    Prova pratica di programmazione 
    
    Interfaccia Dictionary

    @author S. Canazza
    @version 2018
 */
 
public interface Dictionary extends Container
{	
	/** Inserisce la coppia (key, attribute) nel dizionario. 
	* Se la chiave e' gia' presente sovrascrive la coppia. 
	*/
	void insert(Comparable key, Object attribute);
	
	/** Restituisce l'attributo associato alla chiave key nel dizionario. 
	* Se la chiave non e' presente, genera l'eccezione java.util.NoSuchElementException
	*/
	Object find(Comparable key);
	
	/** Elimina la coppia (key, attribute) dal dizionario 
	* e restituisce l'attributo associato alla chiave se questa e' presente.
	* Se la chiave non e' presente genera l'eccezione java.util.NoSuchElementException 
    */
	Object remove(Comparable key);
}
