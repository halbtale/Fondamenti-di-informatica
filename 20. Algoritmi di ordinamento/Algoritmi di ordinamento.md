## algoritmi di ordinamento
### ordinamento per selezione
- Esempio: ordinare insieme numeri interi
- ==Cerco valore minimo==
	- ==lo scambio== al posto del ==primo== valore (così non serve creare nuovo array)
- Proseguo con lo stesso procedimento nella parte non ordinata dell'array
![[Ordinamento per selezione.png|]]

#### implementazione in java
```java
public static void selectionSort(int[] v, int vSize) {
	for (int i = 0; i < vSize - 1; i++) {
		int minPos = findMinPos(v, i, vSize - 1);
		if (minPos != i)
			swap(v, minPos, i);
	}
}
```

#### prestazioni
- $T(n)=O(n^2)$

### ordinamento per fusione (merge sort)
- Idea: dividere l'array in piccole parti, ordinare prima quelle e poi unirle
- Algoritmo
	- ==caso base==: array contiene 1 elemento -> è già ordinato
	- ==passo ricorsivo:==
		- **divido** array iniziale in due parti (circa) uguali
		- **ordino** ciascuna delle due parti separatamente
			- chiamando il metodo merge sort ricorsivamente
		- **fusione**(merge) delle due parti in modo ordinato
			- prendo **primo** elemento da uno dei due vettori scegliendo il più piccolo
![[Ordinamento per fusione.png]]

#### implementazione in java
![[Merge sort code.png]]
#### prestazioni
- Ordine $T(n)=O(n \, \log n)$
