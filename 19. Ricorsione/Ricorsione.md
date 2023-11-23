## ricorsione
### introduzione
- Esempio di funzione ricorsiva: calcolare **fattoriale**
	- metodo che invoca se stesso
```java
public static int factorial(int n) { 
	if (n < 0) throw new IllegalArgumentException(); 
	if (n == 0) return 1; 
	return n * factorial(n - 1); 
}
```

### paradigma di programmazione ricorsivo
- Invocare un metodo mentre si esegue lo stesso metodo
	- sfrutta l'idea di suddividere un problema in sotto-problemi più semplici
- Cosa fa la JVM con la chiamata di un metodo ricorsivo?
	- sospende esecuzione metodo invocante
	- esegue il metodo invocato fino alla sua terminazione
	- riprende l'esecuzione del metodo invocante dal punto in cui era stato sospeso
- Non è mai **necessaria** perché può essere sempre tradotta in modo non ricorsivo

#### struttura algoritmo ricorsivo
- Caso base: valore di partenza noto
	- possono esserci più casi base
- Passo ricorsivo: metodo che chiama se stesso avvicinandosi al caso base

> [!attention] Ricorsione infinita
> Se manca caso base o non si semplifica il problema ad ogni iterazione, il programma terminerà con l'eccezione "StackOverflowError"

### ricorsione semplice
- Invoca il metodo ricorsivo una volta sola
- È possibile tradurla con un ciclo while
	- ricorsione **meno efficiente** del ciclo while
#### ricorsione in coda (tail recursion)
- Il metodo invoca se stesso come ultima azione

### ricorsione multipla
- Quando un metodo invoca se stesso più volte durante la propria esecuzione
- Molto lenta
- Esempio: calcolo dei numeri di Fibonacci
	- $F_n = F_{n-1} + F_{n-2}$
![[Albero ricorsivo.png]]