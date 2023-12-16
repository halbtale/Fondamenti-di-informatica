## classi
### definizione di classe
- Fabbrica di oggetti (istanze)
- Può contenere oggetti o metodi statici
- Sintassi:
```java
tipoAccesso class nomeClasse {
	costruttori
	metodi
	variabili (o campi) di istanza
}
```
### definizione di metodi
#### metodo di istanza
- Funzione presente in una classe
- Firma = intestazione metodo
```java
public tipoVariabileRestituito nomeMetodo(tipoParametro nomeParametro)
```
- Metodo d'**accesso**
	- restituisce informazioni
	- NON modifica l'oggetto
- Metodo **modificatore**
	- altera lo stato di un oggetto
- Metodo **predicativo**
	- restituisce un valore booleano
	- di solito iniziano con "is" o "has"
#### Metodo statico
- Non agisce su oggetti
	- accetta solo parametri espliciti
	- viene chiamato sulla classe
```java
public static nomeTipo nomeMetodo(parametri) // definizione metodo statico
NomeClasse.nomeMetodo(parametri) // chiamare metodo statico
```
### costruttori
- Sintassi:
```java 
tipoAccesso NomeClasse(parametri) {
	// realizzazione del costruttore
}
```
- Obiettivo
	- inizializzare oggetto di una classe
- Costruttore di default
	- **inizializza** automaticamente tutte le variabili di istanza
		- numerico -> 0
		- boolean -> false
		- oggetti -> null
### overloading
#### sovraccarico del costruttore
- Una classe può avere **più costruttori** con lo **stesso nome**
- Il compilatore decide quale costruttore invocare
	- basandosi sul numero e sul tipo dei parametri forniti nell'invocazione
#### sovraccarico dei metodi
- È possibile creare **più metodi** con lo **stesso nome**
	- varia tipo di parametri espliciti accettati
### variabili di istanza (o di esemplare)
- Sintassi:
```java
tipoAccesso TipoVariabile nomeVariabile;
```
- Memorizzano lo stato di un oggetto
#### incapsulamento
- È buona pratica impostare come private le variabili interne
	- e inserire un metodo getNomeVariabile() per accedervi
- Vantaggi:
	- impedisce accesso incontrollato allo stato di un oggetto
### il riferimento null
- Permette di inizializzare una variabile con riferimento a nessun oggetto valido
	- non si possono invocare metodi (**NullPointerException**)
### collaudo
#### come verificare che una classe funzioni funzioni?
- Definisco una classe eseguibile
	- creo oggetti con la classe da collaudare
	- provo tutti i metodi della classe da collaudare
### programma con più classi
- Ciascuna classe in un file diverso
	- tutti nella **stessa cartella**
	- ogni file ha il nome della classe
- Tutte le classi in un unico file
	- solo **UNA** classe pubblica (contenente metodo main)
	- deve avere il nome della classe pubblica
### commenti di documentazione
- Sintassi
```java
/**
	Descrizione metodo
	@param nomeParametro descrizione
	@return descrizione
*/
public void myMethod(parametri) {}
```
- Crea documentazione
```
javadoc NomeClasse.java -d ./output-directory    
```

### package
- Classe della libreria standard -> raccolte in pacchetti
	- organizzate per argomento o finalità
- Pacchetto ```java.lang```importato di default
- Se vengono importate + classi con lo stesso nome: errore di **riferimento ambiguo**
```java
import nomePacchetto.nomeClasse;
import nomePacchetto.*; // importa tutte le classi di un pacchetto
```
[Documentazione](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)
#### alternativa all'importante
```java
java.math.BigInteger a = new java.math.BigInteger("123456789");
```

### uso del parametro implicito
- ```this```indica l'oggetto attuale
	- viene aggiunto automaticamente all'interno dei metodi se non indicato
### membri di classe "statici"
- Classi di utilità
	- non servono per creare oggetti
	- contengono costanti e metodi statici
#### variabili statiche
- Sono condivise tra tutti gli oggetti
- È bene inizializzarle quando si dichiarano
- Consigliato che siano private
```java
private static type nomeVariabile = valoreIniziale;
```
#### costanti statiche
- Valori pubblici e accessibili
```java
public static final type NOME_COSTANTE = valoreIniziale;
```
### visibilità sovrapposte
- Cosa succede quando si definisce variabile locale e di istanza/statica con lo stesso nome?
	- NO errore compilazione
	- prevale variabile locale (effetto di **shadowing**)
	- se voglio utilizzare variabile di istanza/statica, devo aggiungere prefisso ```this.```
### Struttura progetto
#### coesione
- Una classe dovrebbe rappresentare un singolo concetto
	- metodi e costanti strettamente correlati al concetto rappresentato
#### Accoppiamento
- Una classe dipende da un'altra classe
- Relazione di dipendenza rappresentata con UML (Unified Modeling Language)
	- rettangoli = classi
	- freccia con linea tratteggiata = dipendenza
- Quando modifichi una classe, potresti dover modificare anche le classi su cui dipendono

![[Accoppiamento.png]]

> [!tip] Good practice
> Ottimizzare il codice con basso Accoppiamento

#### side effect (effetto collaterale)
- Qualsiasi comportamento **osservabile** al di fuori del metodo stesso
- Esempi di effetto collaterale
	- metodo che modifica parametro implicito
	- metodo che modifica parametro esplicito
	- visualizzazione di dati in uscita