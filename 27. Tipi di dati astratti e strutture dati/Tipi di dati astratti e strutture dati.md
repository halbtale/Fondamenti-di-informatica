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
### pila (stack)
- Pila di oggetti che possono essere inseriti ed estratti secondo comportamento ==LIFO==
	- **Last In, First Out**
	- possono essere inseriti/estratti/ispezionati solo dalla cima della pila
#### interfaccia
- Definisce le operazioni
	- ```push```: inserisce un oggetto in cima alla pila
	- ```pop```: elimina l'oggetto che si trova in cima alla pila
	- ```top```: ispeziona elemento in cima alla pila
```java
public interface Stack extends Container {
	void push(Object obj);
	Object pop();
	Object top();
}
```
#### utilizzo di pile
- Browser
	- andare alla pagina precedente/successiva
- Editor di testi
	- Control Z (operazione di undo)
- Java Stack
	- utilizzata nella JVM