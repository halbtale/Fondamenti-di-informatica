public class Archivio implements DizionarioInvertibile
{
	public Archivio()
	{
		coppie = new Coppia[100];
		tagliaArchivio = 0;
	}

	public int icerca(String chiave)
	{
		for (int i = 0; i < tagliaArchivio; i++)
		{
			if ((coppie[i].getChiave()).compareTo(chiave) == 0)
				return i;
		}
		return -1;
	}

	/* inserisce nel dizionario la Coppia <chiave, attributo> verificando che nel dizionario 
	non ci siano mai due coppie con la stessa chiave (l'inserimento di una coppia con chiave 
	già presente nel dizionario comporta la sostituzione della coppia presente con una nuova).*/

	public void inserisci (String chiave, int attributo)
	{

		Coppia c = new Coppia(chiave, attributo);
    	int i = icerca(chiave);
    	if (i == -1)
      		coppie[tagliaArchivio++] = c;  
    	else
      		coppie[i] = c;
	}

	/* se presente, restituisce la Coppia corrispondente alla chiave inserita come parametro. 
	Se il dizionario non contiene una Coppia corrispondente alla chiave, restituisce null */

	public Coppia cerca (String chiave)
	{
		int i = icerca(chiave);
		if(i < 0 )
			return null;
		else
			return coppie[i];
	}

	/* elimina la Coppia relativa alla chiave e la restituisce. 
	Se la chiave non e’ presente nel dizionario non fa nulla e restituisce null.*/


	public Coppia cancella (String chiave)
	{
		int i = icerca(chiave);
    	if (i == -1)
      		return null;
    	else
    	{ 
    		Coppia tmp = coppie[i];
      		coppie[i] = coppie[--tagliaArchivio];
      		return tmp;
    	}
	}
	
	/* restituisce un array di oggetti Coppia, eventualmente presenti nel dizionario, 
	corrispondenti all'attributo passato come parametro. */

	public Coppia[] cercaPerAttributo (int attributo)
	{
		Coppia[] tmp = new Coppia[tagliaArchivio];
    	int n = 0;
    	for (int i = 0; i < tagliaArchivio; i++)
      	{
      		if (coppie[i].getAttributo() == attributo)
        		tmp[n++] = coppie[i];
      	}
    	Coppia[] ris = new Coppia[n];
    	for (int i = 0; i < n; i++)
      		ris[i] = tmp[i];
      	if(n == 0)
      		return null;
    	return ris;

	}
	
	public int taglia ()
	{
		return tagliaArchivio; 
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