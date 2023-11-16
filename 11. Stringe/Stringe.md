## stringe
### introduzione
- Sequenza di caratteri
- Sono **oggetti**
```java
String name = "John"
```
### metodi utili
#### length
```java
"abc".length() // 3
```
#### substring
- 1 parametro
	- estrai stringa a partire da quell'index
- 2 parametri (startIndex, endIndex)
	- estrae da startIndex fino al carattere prima di quello di endIndex
```java
String greeting = "Hello world";
String sub = greeting.substring(1, 4); // "ell"
String sub2 = greeting.substring(6); // "world"
```
#### change Case
```java
String s = "Hello";
String s1 = s.toUpperCase(); // "HELLO"
String s2 = s.toLowerCase(); // "hello"
```
#### replace
```java
String replace(String target, String replacement)
```

### conversione string - number
- Utilizzo **classe involucro** Integer o Double
- Da string a number
```java
int myInt = Integer.parseInt(myString);
double myDouble = Double.parseDouble(myString);
```
- Da number a string
```java
String myString = Integer.toString(myInt);
```
### i char
- Singolo carattere
```java
char c1 = 'A';
char c2 = '\u00E9'; // Unicode
char c3 = '\n'; // A capo
```
#### estrarre char da string
```java
String s = "John";
char ch = s.charAt(2); // "h"
```

> [!error] Attenzione
> Somma di char somma i valori unicode, non crea una stringa

### printf
-  Formatta numero con 5 caratteri di cui 2 cifre dopo la virgola
```java
System.out.printf(
	"%[modifier][min-width][.precision]specifier", 
	variables
);
```
![[Formattazione.png]]
- Esempio per allineare somma:
```java
System.out.printf("%3d + %3d = %3d%n", a, b, s);
// lunghezza minima: 3 -> lascia spazi vuoti se di meno
```
