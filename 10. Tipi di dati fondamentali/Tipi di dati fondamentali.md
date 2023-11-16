## tipi di dati fondamentali
### tabella riassuntiva
![[Tabella dati fondamentali.png]]
### tipi numerici
#### byte
- Numer intero 8 bit
```java
byte x = 1;
```

#### short
- Numero intero 16 bit
```java
short x = 10;
```
#### INt
- Numero intero 32 bit;
```java
int x = -100000;
```
#### long
- Numero intero 64 bit
```java
long x = 3000000000L;
```
#### float
- Numero virgola mobile 32 bit
```java
float x = 30.2f;
```
#### double
- Numero virgola mobile 64 bit
```java
double x = 102.23972;
```
### valori minimi e massimi
![[MinMax.png]]
> [!error] Attezione
> - Java non segnala overflow -> restituisce solo risultato errato
> - 1/0 (interi) -> ArithmeticException
> - 1/0 (decimali) -> infinito
> - 0/0 (decimali) -> NaN
### errori di arrotondamento
#### mancanza di precisione dei double
- Nel tipo double vi possono essere errori di mancanza di precisione in numeri molto grandi
	- numero limitato di cifre significative
	- può sbagliare anche di più unità
- È importante considerare la precisione di ogni tipo prima di fare calcoli
#### numeri binari periodici
- Numeri decimali esatti
	- non hanno tutti rappresentazione esatta in binario
- Esempio: 4.35 -> NO codifica esatta in binario
### assegnazioni con conversione
- Ammesse senza conversioni 
	- assegnazioni di tipi compatibili
	- int -> long
	- float -> double
#### type casting
- Assegnazioni con possibile perdita di precisione
```java
double doubleVar = 2.99;
int intVar = (int) doubleVar;
// intVar -> 2
```
#### arrotondamento
```java
double doubleVar = 2.99;
int intVar = (int) Math.round(doubleVar);
// intVar -> 3
```
#### errori di approssimazione in operazioni aritmetiche
- Divisioni tra numeri interi danno risultato intero
```java
System.out.println(7 / 4) // 1
System.out.println(7.0 / 4.0) // 1.75
```

### package java.math.*
- Classi:
	- BigInteger
	- BigDecimal
- Mi permette di avere un qualunque livello di precisione
### classe math
- Non serve importarla
- Presenta metodi statici e costanti utili
```java
Math.pow(x, y);
Math.sqrt(x);
Math.log(x); 
Math.sin(x);
Math.E;
Math.PI;
```
### abbreviazioni per assegnazioni e aritmetica
```java
counter += 5;
counter *= 2;
counter++;
counter--;
```

### boolean
- Può assumere solo due valori: ```true```e ```false```
- Sono chiamati anche "flag"