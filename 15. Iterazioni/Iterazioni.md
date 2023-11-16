## iterazioni
### ciclo while
- Enunciato while realizza un **ciclo**
- Valuta la condizione all'inizio
```java
while (condizione) {
	// enunciati
}
```
#### "ciclo e mezzo"
- Ciclo che utilizza una variabile booleana per verificare se proseguire il ciclo o meno
- Esempio di utilizzo
	- l'utente deve inserire un insieme di valori la cui dimensione non è definita
#### continue e break (deprecato)
- ```continue```
	- termina attuale iterazione del ciclo e prosegue con la successiva
- ```break```
	- termina ciclo
### ciclo do
- Enunciato do realizza un **ciclo**
- Valuta la condizione alla fine (dopo la prima volta)
```java
do {
	enunciato
} while (condizione)
```
### ciclo fOr
- Enunciato for realizza un **ciclo**
```java
for (int i = inizio; i < fine; i++) { 
	enunciati 
}
```
#### ciclo simmetrico e asimmetrico
- Simmetrico: ```i = a; i <= n```
- Asimmetrico: ```i = a; i < n```
