## lettura input
### classe Scanner
- Consente di leggere dati da qualsiasi flusso in ingresso
- Necessario importarla
```java
import java.util.Scanner;
import java.util.Locale; // per formato localizzazione input
```
- Creare oggetto
```java
Scanner in = new Scanner(System.in);
```
- Chiudere l'oggetto se non si usa più
```java
in.close();
```
- Leggere da standard input valori numerici
```java
int number = in.nextInt();
double number = in.nextDouble();
byte number = in.nextByte();
```
- Leggere da standard input stringhe
```java
String s = in.next(); // fino a SP, \t, \n, \r
String s = in.nextLine(); // fino a \n, \r
```
- Leggere numeri decimali con notazione anglosassone (separatore = .)
```java
in.useLocale(Locale.US);
```

>[!error] Eccezioni
>- ```NoSuchElementException```: next/nextLine se input non è disponibile
>- ```InputMismatchException```: nextInt/nextDouble se input non è formato numerico
>- ```IllegalStateException```: si cerca di leggere con Scanner chiuso

