## tipi di dati astratti e strutture dati
### definizione
#### struttura dati (data structure)
- Modo sistematico di organizzare i dati in un contenitore e di controllarne le modalità d'accesso
- Si definisce attraverso una **classe**
#### tipo di dato astratto (adt, abstract data type)
- Rappresentazione astratta di una struttura dati
	- specifica **tipo** di dati memorizzati
	- specifica **operazioni** che si possono eseguire sui dati
- Si definisce attraverso una **interfaccia**
	- descrive **comportamento** che sarà assunto da una classe
	- la classe che rappresenta la struttura dati **implementa** come vengono eseguite le operazioni
### operazioni definite da un aDt
- ==Inserimento== di un elemento
- ==Rimozione== di un elemento
- ==Ispezione== degli elementi contenuti nella struttura
- ==Ricerca== di un elemento all'interno della struttura
### contenitore generico
- Super-interfaccia da cui derivano anche gli altri ADT attraverso ereditarietà
```java
public interface Container {
	boolean isEmpty();
	void makeEmpty();
}
```
### estrarre oggetti da strutture dati
- Bisogna usare un **cast** per ottenere un riferimento del tipo originario
	- si può controllare che sia del tipo corretto attraverso operatore ```instanceof```
