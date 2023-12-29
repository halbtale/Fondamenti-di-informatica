## mappe e dizionari
### definizione di mappa
- ADT che contiene dati come ==coppie chiave/valore==
- Ogni chiave deve essere **UNICA**
	- viene utilizzata come identificatore
	- utilizzata per effettuare ricerca/rimozione elementi
### definizione di dizionario
- Simile ad una mappa
- **NON** si richiede che le chiavi siano uniche
	- possono essere associate a **più valori**
- Si distinguono in:
	- ==Dizionari ordinati==
		- chiavi ordinate
	- ==Dizionari non ordinati==
		- chiavi non ordinate
- La trattazione si soffermerà su dizionari a chiave unica (= mappe)
### interfaccia
```java
public interface Dictionary extends Container {
	void insert(Comparable key, Object value);
	void remove(Comparable key);
	Object find(Comparable key);
}
```

- Definiamo una nuova **eccezione**
	- ```class DictionaryItemNotFoundException extends RuntimeException```

### implementazione 
- Struttura dati: array riempito solo in parte
- Il dizionario contiene oggetti di tipo ```Pair```
	- coppie chiave/valore
- È possibile scegliere se:
	- mantenere chiavi **ordinate**
		- + performante nella lettura (si può usare binary search)
	- lasciare chiavi **non ordinati**
### la classe pair
- Contiene elementi formati da **coppie chiave/valore**
- Due **campi di esemplare**
	- key (Comparable)
	- value (Object)
- Metodi di accesso e modificatori per questi campi di esemplare

### implementazione dizionario non ordinato
![[ArrayDictionary.png|420]]

### implementazione dizionario ordinato
- L'array deve sempre essere mantenuto ordinato con Insertion Sort
	- ogni volta che si inserisce o toglie un elemento
- La ricerca deve avvenire attraverso **binary search** in quanto l'array è ordinato

### performance dizionario
#### dizionario con array non ordinato
- **Ricerca**
	- prestazione $O(n)$
	- ricerca lineare
- **Rimozione**
	- prestazione $O(n)$
	- bisogna effettuare ricerca lineare e poi spostare nella posizione trovata l'ultimo elemento
- **Inserimento**
	- prestazione $O(n)$
	- Bisogna rimuovere (sovrascrivere) un elemento con la stessa chiave, se c'è, e poi inserire il nuovo elemento nella ultima posizione dell’array (l’ordinamento non interessa)
#### dizionario con array ordinato
- **Ricerca**
	- prestazione $O(\log n)$
	- binary search
- **Rimozione** 
	- prestazione $O(n)$
	- bisogna effettuare una ricerca e poi spostare mediamente $\frac{n}{2}$ elementi
- **Inserimento**
	- prestazione $O(n)$
		- o con algoritmo diverso $O(n \,\log n)$
	- si può usare insertion sort in un array ordinato
![[Performance.png]]

>[!summary] Prestazioni in sintesi:
>- find: $O(\log n)$ (ordinato) - $O(n)$ (non ordinato)
>- insert: $O(n)$
>- remove: $O(n)$

