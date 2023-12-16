## variabili
### Introduzione
- ==Le variabili sono spazi di memoria, identificati da un nome, che possono conservare valori di un determinato tipo==
### variabili in java
```java
// Definizione
nomeTipo nomeVariabile;
// Assegnazione
nomeVariabile = espressione;
// Definizione e assegnazione (inizializzazione)
nomeTipo nomeVariabile = espressione;
```
#### restrizioni sui nomi
- Nome può essere composto solo da
	- lettere
	- numeri
	- _
- Deve
	- iniziare con una lettera
	- non può contenere simboli riservato
- Case sensitive
#### convenzioni
- Variabili e metodi -> iniziano con minuscola
- Classi -> iniziano con maiuscola
- Nomi composti -> camelCase e PascalCase

### costanti
- Non possono essere modificate
```java
final nomeTipo NOME_COSTANTE = espressione;
```
### ciclo di vita di una variabile
- Ciclo di vita = tempo in cui continuano ad usare lo spazio in memoria a loro riservato
- Meccanismo di **garbage collection**
	- memoria liberata eliminando variabili non più utilizzate dal punto di vista logico
	- avviene in modo ciclico
#### variabile locale
- Creata:
	- eseguito enunciato quando viene definita
- Eliminata
	- esce dal blocco di enunciati in cui è definita
#### variabile parametro
- Creata
	- creato il metodo
- Eliminata
	- terminato il metodo
#### variabile di istanza
- Creata
	- creato oggetto in cui appartiene
- Eliminata
	- oggetto viene eliminato (ovvero quando non esiste più nessun riferimento ad esso)
#### variabile statica
- Creata
	- quando la JVM carica la classe per la prima volta
- Eliminata
	- classe scaricata dalla JVM
### allocazione della memoria in java
- Eseguo programma -> viene assegnata **area di memoria**
	- una parte statica per **memorizzare il codice**
	- **Java Stack**
		- dinamica
		- memorizzate parametri e variabili locali
	- **Java Heap** (heap = cumulo)
		- dinamica
		- memorizza oggetti
![[Gestione di memoria.png]]
