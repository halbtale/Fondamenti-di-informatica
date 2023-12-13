## Code (queue)
### caratteristiche generali
- Comportamento definito ==FIFO==
	- **First In, First Out**
	- primo inserito è il primo ad essere estratto
	- può essere ispezionato solo il primo oggetto della coda
#### utilizzo delle code
- Simulazione sportello bamncario
	- clienti in coda
- File da stampare vengono inseriti in una coda di stampa
- Task scheduler
#### coda circolare
- Politica ==round robin==
- Ciò che viene estratto poi viene essere re-inserito
![[Coda circolare.png]]
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
