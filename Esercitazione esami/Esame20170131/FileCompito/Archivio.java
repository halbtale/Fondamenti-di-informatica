public class Archivio implements DizionarioInvertibile
{
	/* Crea un archivio vuoto */
	
	public Archivio()
	{
		
	}

	/* inserisce nel dizionario la Coppia <chiave, attributo> verificando che nel dizionario 
	non ci siano mai due coppie con la stessa chiave (l'inserimento di una coppia con chiave 
	già presente nel dizionario comporta la sostituzione della coppia presente con una nuova).*/

	public void inserisci (String chiave, int attributo)
	{

	}

	/* se presente, restituisce la Coppia corrispondente alla chiave inserita come parametro. 
	Se il dizionario non contiene una Coppia corrispondente alla chiave, restituisce null */

	public Coppia cerca (String chiave)
	{

	}

	/* elimina la Coppia relativa alla chiave e la restituisce. 
	Se la chiave non e’ presente nel dizionario non fa nulla e restituisce null.*/

	public Coppia cancella (String chiave)
	{

	}
	
	/* restituisce un array di oggetti Coppia, eventualmente presenti nel dizionario, 
	corrispondenti all'attributo passato come parametro. */

	public Coppia[] cercaPerAttributo (int attributo)
	{

	}
	
	public int taglia ()
	{
		
	}

	public String toString()
	{
		String temp = "";
		for(int i = 0; i < tagliaArchivio; i++ )
		{
			temp = temp + "" + (i+1) + ") " + coppie[i].toString() + "\n" ;

		}
		return temp;
	}

	int tagliaArchivio;
	Coppia[] coppie;
}