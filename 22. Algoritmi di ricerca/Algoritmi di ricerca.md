## algoritmi di ricerca
### ricerca lineare o sequenziale
- Array NON ordinato
- Scorrere gli elementi dell'array finché non si trova l'elemento o si finisce l'array
```java
public static int linearSearch(int[] v, int vSize, int value) {
	for (int i = 0; i < vSize; i++)
		if (v[i] == value) return i; // trovato valore
	
	return -1; // valore non trovato
}
```

### ricerca binaria
- Array **ordinato**
- Algoritmo
	- divido array in due
	- confronto elemento che sto cercando con quello che si trova circa a metà
	- scarto uno dei sottoarray in base al fatto che sia maggiore o minore
	- ripeto finché non lo trovo
- È comodo scriverlo in modo ricorsivo