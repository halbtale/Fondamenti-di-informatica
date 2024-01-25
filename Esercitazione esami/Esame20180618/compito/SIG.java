import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Classe SIG
 * rappresenta un segnale campionato
 *
 * NOME E COGNOME CANDIDATO: Alberto Heissl
 * MATRICOLA: 2101739
 * DATA: 30/01/2024
 * POSTAZIONE: 10
 *
 */ 
public class SIG implements Dizionario
{
	final static int INIT_SIZE = 5;
	MIS[] misArray;
	int misArraySize = 0;

	public SIG(String filename) throws IOException {
		misArray = new MIS[INIT_SIZE];
		makeEmpty();
		readFromFile(filename);
	}

	private void readFromFile(String filename) throws IOException {
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);

		while (in.hasNextLine()) {
			String line = in.nextLine();
			
			String currentGroup = "";

			for (int i = 0; i<line.length(); i++) {
				char c = line.charAt(i);
				if (c == '(') {
					currentGroup = "";
				} else if (c == ')') {
					Scanner scan = new Scanner(currentGroup);

					String tRaw = scan.next();
					String vRaw = scan.next();

					int t = Integer.parseInt(tRaw);
					double v = Double.parseDouble(vRaw);

					insert(t, v);
				} else {
					currentGroup += c;
				}
			}
		}

		reader.close();
		in.close();
	}


	/**
		 rende vuoto il contenitore
	*/
	public void makeEmpty() {
		misArraySize = 0;
	}

	/**
		 verifica se il contenitore e' vuoto
		@return true se il contenitore e' vuoto, false altrimenti
	*/
	public boolean isEmpty() {
		return misArraySize == 0;
	}
	
	/**
		 @return il numero di elementi nel contenitore
	*/
	public int size() {
		return misArraySize;
	}
	
	/**
		 inserisce nel contenitore la coppia t/v
		@param t la chiave specificata
		@param v il valore specificato
	*/
	public void insert(int t, double v) {
		if (misArraySize == misArray.length) resize();

		remove(t);

		MIS newMis = new MIS(t, v);
		
		misArraySize++;

		int i;
		for (i = misArraySize - 1; i > 0 && misArray[i-1].compareTo(newMis) > 0; i--) {
			misArray[i] = misArray[i-1];
		}
		misArray[i] = newMis;
	}
	
	/**
		 restituisce il valore associato alla chiave specificata
		@param t la chiave specificata
		@return il valore associato alla chiave specificata
		@throws java.util.NoSuchElementException se la chiave non e' nel contenitore
	*/
	public double find(int t) throws java.util.NoSuchElementException {
		return misArray[binarySearch(t, 0, misArraySize - 1)].valore();
	}

	private int binarySearch(int t, int startIndex, int endIndex) throws java.util.NoSuchElementException {
		if (startIndex > endIndex) throw new java.util.NoSuchElementException();
		int midIndex = (startIndex + endIndex) / 2;
		if (misArray[midIndex].tempo() == t) {
			return midIndex;
		} else if (misArray[midIndex].tempo() > t ) {
			return binarySearch(t, startIndex, midIndex-1);
		} else {
			return binarySearch(t, midIndex+1, endIndex);
		}
	}

	

	/**
		 rimuove la coppia t/v dal contenitore. Se la chiave non e' presente nel
		contenitore, termina silenziosamente
		@param t la chiave specificata
	*/
	public void remove(int t) {
		try {
			int indexToRemove = binarySearch(t, 0, misArraySize - 1);
			misArraySize--;
			for (int i = indexToRemove; i<misArraySize; i++) {
				misArray[i] = misArray[i+1];
			}
		} catch (java.util.NoSuchElementException e) {

		}
	}

	/**
	 * Restituisce l'array ordinato delle coppie tempo-valore
	 * @return array di MIS
	 */
	public MIS[] toSortedArray() {
		MIS[] sortedArray = new MIS[misArraySize];
		System.arraycopy(misArray, 0, sortedArray, 0, misArraySize);
		return sortedArray;
	}

	private void resize() {
		MIS[] resizedArray = new MIS[misArraySize * 2];
		System.arraycopy(misArray, 0, resizedArray, 0, misArraySize);
		misArray = resizedArray;
	}
}