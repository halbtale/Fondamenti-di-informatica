## pile
### caratteristiche generali)
- Pila di oggetti che possono essere inseriti ed estratti secondo comportamento ==LIFO==
	- **Last In, First Out**
	- possono essere inseriti/estratti/ispezionati solo dalla cima della pila
#### utilizzo di pile
- Browser
	- andare alla pagina precedente/successiva
- Editor di testi
	- Control Z (operazione di undo)
- Java Stack
	- utilizzata nella JVM
### interfaccia
- Definisce le operazioni
	- ==push==: inserisce un oggetto in cima alla pila
	- ==pop==: elimina l'oggetto che si trova in cima alla pila
	- ==top==: ispeziona elemento in cima alla pila
```java
public interface Stack extends Container {
	void push(Object obj);
	Object pop();
	Object top();
}
```
### realizzazione della pila
- Struttura dati: **array "riempito solo in parte"**
- Definiamo due nuove **eccezioni**
	- ```class EmptyStackException extends RuntimeException```
		- pop() su array vuoto
	- ```class FullStackException extends RuntimeException```
		- push() su array pieno
- Senza ridimensionamento:
![[FixedArrayStack.png|400]]
- Con Ridimensionamento
![[GrowingArrayStack.png|500]]
- Nel complesso:
![[Hierarchy.png|200]]
### analisi prestazioni
- Dipendono dalla **definizione** della **struttura dati** e non dalla sua interfaccia
- FixedArrayStack
	- tempo esecuzione di ogni operazione costante: $O(1)$
- Tempo di esecuzione di GrowingArrayStack
	- unica differenza è ```push```
#### analisi ammortizzata delle prestazioni asintotiche
- Si applica all'analisi di tempi di esecuzione dei **metodi di inserimento** in strutture dati
- Analisi del ==tempo di esecuzione medio== nel caso **peggiore**
- su ```push``` con costante **moltiplicativa**
	- (n-1) volte senza resize: $O(1)$
	- n-esima volta: resize $O(n)$
	- $T(n)=\frac{[(n-1)*O(1)+O(n)]}{n}=\frac{O(n)}{n}=O(1)$
- su ```push```con costante **addittiva**
	- dimensione diventa $n+k$
	- operazioni lente sono $\frac{n}{k}$ (ogni k elementi devo effettuare un resize) e sono $O(n)$
	- operazioni veloci senza resize sono dunque $n-\frac{n}{k}$
	- sia $n-\frac{n}{k}=\frac{k-1}{k}n=O(n)$ e $\frac{n}{k}=\frac{1}{k}n=O(n)$
	- $T(n)=\frac{(n-\frac{n}{k} )*O(1)+(\frac{n}{k})*O(n)}{n}=\frac{O(n)+n*O(n)}{n}=\frac{O(n)}{n}+O(n)=O(1)+O(n)=O(n)$
- Considerazioni generali
	- push ha prestazioni $O(1)$ per qualsiasi costante **moltiplicativa**
	- push ha prestazioni $O(n)$ per qualsiasi costante **addittiva**

### pile di dati fondamentali
- Trasformare dato fondamentale in oggetto attraverso **classi involucro** (**wrapper**)
```java
Integer myIntObj1 = new Integer(2);
Integer myIntObj2 = 2; // sintassi con auto-boxing
int myInt1 = myIntObj1.intValue();
int myInt2 = myIntObj2; // sintassi con auto-unboxing
```