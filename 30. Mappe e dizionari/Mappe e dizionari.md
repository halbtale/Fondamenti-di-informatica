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
