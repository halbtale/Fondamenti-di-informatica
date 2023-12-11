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

