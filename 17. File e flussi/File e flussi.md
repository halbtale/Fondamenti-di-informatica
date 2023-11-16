## file e flussi
### leggere file di testo
- Creo oggetto ```FileReader```
	- apre in lettura il file
	- se il file non esiste: ```FileNotFoundException```
- Creo oggetto ```Scanner```
- Collegare oggetto Scanner al FileReader
```java
FileReader reader = new FileReader("input.txt");
Scanner in = new Scanner(reader);
String line = in.nextLine();
in.close();
```

>[!error] Attenzione
>Ricorda di chiudere i file aperti in lettura ```in.close()```

#### rilevare la fine dell'input
- Basta usare ```hasNext()```o ```hasNextLine()```

### scrivere su file di testo
- Creo oggetto ```PrintWriter``` e collegarlo a un nuovo file
	- sovrascrive file precedente se presente
```java
PrintWriter out = new PrintWriter("output.txt");
```
- Per abilitare append (e non sovrascrivere file)
```java
FileWriter writer = new FileWriter("file.txt", true);
PrintWriter out = new PrintWriter(writer);

out.println("Una frase");
```

>[!error] Attenzione
>- Ricorda di chiudere i file aperti in scrittura ```out.close()```
>- È obbligatorio gestire IOException

### scomposizione di stringhe
- Utente inserisce + dati per riga
- Si può leggere l'intera riga (nextLine) e poi estrarre le sottostringhe relative ai singoli dati
	- ogni sotto-stringa delimitata da caratteri speciali (come spazi) è definita **token** o **lessema**
#### sottostringhe separate da spazi 
```java
String line = "Dato1 Dato2";
Scanner scan = new Scanner(line);

while (scan.hasNext()) {
	String token = scan.next();
	// elabora token
}
```

#### sottostringhe separate da altri delimitatori
```java
Scanner scan = new Scanner("Dato1/Dato2/Dato3/Dato4");
scan.useDelimiter("/");

System.out.println("The delimiter in use is "+scan.delimiter());

while (scan.hasNext()) {
	String token = scan.next();
	// elabora token
}
```

### Reindirizzamento e canalizzazione
- Re-indirizzamento dell'input standard
	- System.in sarà collegato al file
```bash
java IlMioProgramma < input.txt
```

- Re-indirizzamento dell'output standard
	- System.out sarà collegato  al file
```bash
java IlMioProgramma > output.txt
```

- **Pipes**
	- se hai bisogno di passare output di un programma all'input di un altro
	- uso simbolo ```|``` 
```shell
java IlMioProgramma < testo.txt | sort > testoOrdinato.txt
```

### flusso di errore standard
- ```System.err```
	- serve per comunicare degli errori all'utente