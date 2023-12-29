## Code (queue)
### caratteristiche generali
- Comportamento definito ==FIFO==
	- **First In, First Out**
	- primo inserito è il primo ad essere estratto
	- può essere ispezionato solo il primo oggetto della coda
#### utilizzo delle code
- Simulazione sportello bancario
	- clienti in coda
- File da stampare vengono inseriti in una coda di stampa
- Task scheduler
### interfaccia
- Definisce le operazioni:
	- ==enqueue==: inserisce oggetto nella coda
	- ==dequeue==: elimina dalla coda oggetto inserito per primo
	- ==getFront==:  esamina primo oggetto senza estrarlo
- + operazioni base del ADT "container"
```java
public interface Queue extends Container {
	void enqueue(Object obj);
	Object dequeue();
	Object getFront();
}
```
### realizzazione della coda
- Definiamo due nuove **eccezioni**
	- ```class EmptyQueueException extends RuntimeException```
	- ```class FullQueueException extends RuntimeException```
#### implementazione con array riempito solo in parte
![[SlowFixedArrayQueue.png|400]]
- Il metodo ```dequeue```ha complessità $O(n)$
	- non è molto efficiente
#### implementazione con "array riempito solo nella parte centrale"
- Si usano due indici
	- ==front==: indica primo elemento nella coda
	- ==back==: indica primo posto libero dopo ultimo elemento nella coda
	- numeri di elementi: back - front
![[Array riempito parte centrale.png]]
![[FixedArrayQueue.png|400]]
- Il metodo ```dequeue```ha ora efficienza $O(1)$

#### implementazione con array a ridimensionamento dinamico
```java
public void enqueue(Object obj) {
	if (back == array.length)
		array = resize(2 * array.length);
	array[back++] = obj;
}
```
- Tutte le operazioni continuano ad avere efficienza: $O(1)$
>[!danger] Attenzione
>Si rischia, se aumenta molto indice front, di avere un array quasi totalmente vuoto

### coda con array circolare
- Array in cui, quando è pieno, si re-inizia ad inserire elementi dal primo elemento
- È pieno solo quando ```front == back```
![[Array circolare.png]]
#### implementazione con array statici
![[FixedCircularArrayQueue.png|600]]

#### ridimensionare con array circolare
- Potrebbe dare array pieno anche quando l'indice ```back```non è l'ultimo elemento
- Sposto gli elementi prima di front nella seconda metà dell'array
![[Resize array circolare.png]]
```java
public void enqueue(Object obj) {
	if (increment(back) == front) {
		array = resize(2 * array.length);
		if (back < front) {
			System.arraycopy(array, 0, array, array.length / 2, back);
			back += array.length / 2;
		}
	}
	array[back] = obj;
	back = increment(back);
}
```

#### coda circolare
- Politica ==round robin==
	- la CPU esegue una porzione del processo che ha atteso più a lungo e poi viene re-inserito nell'ultima posizione
![[Coda circolare.png]]

### gerarchia di classi e interfacce
![[GrowingCircularArrayQueue.png|500]]

### coda doppia (deque)
- Elementi possono venire inseriti ed estratti ai due estremi
#### interfaccia
```java
public interface Deque extends Container { 
	void addFirst(Object obj);
	void addLast(Object obj);
	
	Object removeFirst();
	Object removeLast();

	Object getFirst();
	Object getLast();

	int size();
}
```
- Può essere realizzata con **array circolare ridimensionabile**
- Tutti i metodi hanno prestazioni $O(1)$
### analisi prestazioni

>[!summary] Prestazioni in sintesi:
>- enqueue: $O(1)$ 
>- dequeue: $O(1)$ (usando 2 indici) - $O(n)$ (usando 1 indice) 
>- getFront: $O(1)$ 

