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
