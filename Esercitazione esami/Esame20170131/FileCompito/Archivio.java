public class Archivio implements DizionarioInvertibile
{
	private static final int INIT_ARRAY_SIZE = 5;
	private Coppia[] coppie;
	private int tagliaArchivio;

	/* Crea un archivio vuoto */
	
	public Archivio()
	{
		coppie = new Coppia[INIT_ARRAY_SIZE];
		tagliaArchivio = 0;
	}

	/* inserisce nel dizionario la Coppia <chiave, attributo> verificando che nel dizionario 
	non ci siano mai due coppie con la stessa chiave (l'inserimento di una coppia con chiave 
	già presente nel dizionario comporta la sostituzione della coppia presente con una nuova).*/

	public void inserisci (String chiave, int attributo)
	{
		if (chiave == null) return;
		
		cancella(chiave);

		if (tagliaArchivio == coppie.length) coppie = resize(coppie, tagliaArchivio * 2);
		
		Coppia nuovaCoppia = new Coppia(chiave, attributo);

		tagliaArchivio++;

		int i;
		for (i = tagliaArchivio - 1; i>0 && nuovaCoppia.getChiave().compareTo(coppie[i-1].getChiave()) < 0; i--) {
			coppie[i] = coppie[i - 1];
		}
		coppie[i] = nuovaCoppia;
	}

	/* se presente, restituisce la Coppia corrispondente alla chiave inserita come parametro. 
	Se il dizionario non contiene una Coppia corrispondente alla chiave, restituisce null */

	public Coppia cerca (String chiave)
	{
		int index = binarySearch(chiave);
		if (index == -1) return null;
		return coppie[index];
	}

	// private int linearSearch(String chiave) {
	// 	for (int i = 0; i<tagliaArchivio; i++) {
	// 		if (coppie[i].getChiave().compareTo(chiave) == 0) return i;
	// 	}
	// 	return -1;
	// }

	private int binarySearch(String chiave) {
		return binarySearch(chiave, 0, tagliaArchivio - 1);
	}

	private int binarySearch(String chiave, int start, int end) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		if (chiave.compareTo(coppie[mid].getChiave()) == 0) {
			return mid;
		} else if (chiave.compareTo(coppie[mid].getChiave()) < 0) {
			return binarySearch(chiave, start, mid - 1);
		} else {
			return binarySearch(chiave, mid+1, end);
		}
	}

	/* elimina la Coppia relativa alla chiave e la restituisce. 
	Se la chiave non e’ presente nel dizionario non fa nulla e restituisce null.*/

	public Coppia cancella (String chiave)
	{
		int index = binarySearch(chiave);
		if (index == -1) return null;
		Coppia removedCoppia = coppie[index];
		tagliaArchivio--;
		for (int i = index; i<tagliaArchivio - 1; i++) {
			coppie[i] = coppie[i+1];
		}
		return removedCoppia;
	}
	
	/* restituisce un coppie di oggetti Coppia, eventualmente presenti nel dizionario, 
	corrispondenti all'attributo passato come parametro. */

	public Coppia[] cercaPerAttributo (int attributo)
	{
		Coppia[] foundCoppie = new Coppia[tagliaArchivio];
		int foundCoppieSize = 0;

		for (int i = 0; i<foundCoppie.length; i++) {
			if (coppie[i].getAttributo() == attributo) {
				foundCoppie[foundCoppieSize++] = coppie[i];
			}
		}

		return resize(foundCoppie, foundCoppieSize);
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

	private Coppia[] resize(Coppia[] array, int newLength) {
		Coppia[] resizedArray = new Coppia[newLength];
		System.arraycopy(array, 0, resizedArray, 0, Math.min(newLength, array.length));
		return resizedArray;
	}
}