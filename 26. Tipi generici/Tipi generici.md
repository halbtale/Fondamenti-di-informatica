## tipi generici
### interfaccia integrata comparable
- Utilizzando interfaccia comparable
	- compilatore emette un warning
	- "MyClass.java uses unchecked or unsafe operations."

#### metodo pigro
- Come risolvere il problema? Ignorare il problema
```shell
javac -nowarn MyClass.java
```
#### interfaccia comparable parametrica
- Grazie ai tipi generici, si può fare in modo di evitare di "confrontare mele con pere"
- Implementare interfaccia parametrica
```java
public interface Comparable<T> {
	int compareTo(T otherObject);
}
```
- Utilizzo interfaccia parametrica
```java
public class BankAccount implements Comparable<BankAccount> {
	public int compareTo(BankAccount obj) {
		if (balance < obj.balance) return -1;
		if (balance > obj.balance) return 1;
		return 0;	
	}
}
```

> [!error] Attenzione
> Se tento di confrontare oggetti diversi ottengo ```ClassCastException```

#### metodo statico generico
- Si possono utilizzare i generics anche per metodi statici
- Esempio:
```java
public static <T> int linearSearch(T[] array, int arraySize, T searchValue) 
{...}
```
#### tipi generici con restrizioni
- Si può utilizzare l'operatore ```extends```per limitare un tipo generico ad un particolare type
- Esempio: solo i tipi che implementano comparable
```java
public static <T extends Comparable<T>> int findMin(T[] array, int arraySize) 
{...}
```
