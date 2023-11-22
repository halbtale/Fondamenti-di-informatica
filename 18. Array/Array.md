## array
### caratteristiche generali
- Struttura dati (è un oggetto)
- Permette di una sequenza ordinata di valori
	- sia dati fondamentali che oggetti
- Può essere utilizzato anche come parametro esplicito
- Sintassi:
```java
NomeTipo[] nomeRiferimento = new NomeTipo[lunghezza]

riferimentoArray[indice]
```

> [!error] Eccezioni
> - Indice sbagliato: ```ArrayIndexOutOfBoundsException```

#### inizializzazione di un array
```java
int[] primes = {2,3,5};
```

### effettuare resize di un array

```java
public static int[] resizeIntArray(int[] oldArray, int newLength) {
	if (newLength < 0 || oldArray == null) 
		throw new IllegalArgumentException();
	
	int[] newArray = new int[newLength];
	
	int n = Math.min(oldArray.length, newLength);

	for (int i = 0; i < n; i++)
		newArray[i] = oldArray[i];
		
	return newArray;
}
```

### copiare un array
- Usare ```System.arraycopy()```
```java
System.arraycopy(sourceArray, firstSourceArrayIndex, targetArray, firstTargetArrayIndex, numberOfValuesToCopy)
```

- Usare ```clone()```
	- serve fare il cast
```java
double[] otherValues = (double[]) values.clone()
```

### array riempiti solo in parte
- Utilizzo un array molto grande ma lo riempio solo in parte
	- come faccio a sapere fino a che valore è stato riempito?
- Tengo traccia dell'indice fino alla quale lo ho riempito (creando variabile ```int size```)

#### statici
- Se si supera la dimensione massima, lancia un'eccezione

#### dinamici
- Se si supera la dimensione massima, si effettua un resize
	- raddoppio dimensione di partenza (molto efficiente)

### array di numeri casuali
- Utilizzare il metodo ```Math.random()```
	- restituisce numero ```double``` in ```[0,1[```

```java
public static int[] randomIntArray(int length, int n) {
	int[] a = new int[length];

	for (int i = 0; i < a.length; i++)
		a[i] = (int) (n * Math.random());
		
	return a;
}
```

### print array
- È un oggetto, serve costruire la stringa manualmente
```java
public static String printArray(int[] v, int vSize) {
	String s = "[";
	
	for (int i = 0; i < vSize; i++)
		s = s + v[i] + " ";
		
	s = s + "\b]";
	
	return s;
}
```

### eliminazione di elementi in un array
#### array non ordinato
- Copio l'ultimo elemento dell'array nella posizione dell'elemento da eliminare
- Ridimensionare l'array (o ridurre indice con array riempiti solo in parte)

```java
public static void remove(int[] v, int vSize, int index) {
	v[index] = v[vSize - 1];
}
```

#### array ordinato
- Spostare tutti gli elementi dell'array successivi all'elemento da rimuovere alla posizione inferiore
	- dall'indice basso all'alto
- Ridimensionare l'array (o ridurre indice con array riempiti solo in parte)
```java
public static void removeSorted(int[] v, int vSize, int index) {
	for (int i = index; i < vSize - 1; i++)
		v[i] = v[i + 1];
}
```

### inserire elemento in array
#### array ordinato
- Ridimensionare array (se è pieno)
	- dall'indice alto al basso
- Spostare tutti gli elementi successivi alla posizione di inserimento
```java
public static int[] insert(int[] v, int vSize, int index, int val) {
	if (vSize == v.length)
		v = resize(v, 2 * v.length);
	
	for (int i = vSize; i > index; i--)
		v[i] = v[i - 1];
		
	v[index] = val;
	
	return v;
}
```

### trovare valore in array
#### ricerca lineare
- Array NON ordinato
- Scorrere gli elementi dell'array finché non si trova l'elemento o si finisce l'array
```java
public static int linearSearch(int[] v, int vSize, int value) {
	for (int i = 0; i < vSize; i++)
		if (v[i] == value) return i; // trovato valore
	
	return -1; // valore non trovato
}
```
#### valore minimo
- Inizializzare valore candidato con il primo elemento
- Confrontare il candidato con gli elementi rimanenti
- Aggiornare valore candidato se viene trovato valore minore
```java
public static int findMin(int[] v, int vSize) { 
	int min = v[0]; 
	
	for (int i = 1; i < vSize; i++) 
		if (v[i] < min) min = v[i]; 
		
	return min; 
}
```

#### valore massimo
- Inizializzare valore candidato con il primo elemento
- Confrontare il candidato con gli elementi rimanenti
- Aggiornare valore candidato se viene trovato valore maggiore
```java
public static int findMax(int[] v, int vSize) { 
	int max = v[0]; 
	
	for (int i = 1; i < vSize; i++) 
		if (v[i] > max) max = v[i]; 
		
	return max; 
}
```

### array bidimensionali
- Chiamati anche **matrici**
- Ogni elemento è identificato da una coppia di indici
```java
int[][] matrix = new int[][];
```

### argomenti sulla riga comandi
- Si possono passare dei parametri quando si esegue il programma
- Verranno contenuti in ```String[] args```
```sh
java MyApp arg1 arg2 arg3
```

### array paralleli
- Creare diversi array per contenere dati **fortemente correlati**
	- indici sono tra loro correlati
	- rappresentano proprietà diverse di uno stesso concetto

>[!error] Attenzione
>Non conviene fare array paralleli ma piuttosto meglio array di oggetti!

