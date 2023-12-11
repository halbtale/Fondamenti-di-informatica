## ereditarietà
### introduzione
- Uno dei principi basilari della programmazione orientata agli oggetti
- Obiettivo **riusabilità del codice**
- Creare una classe che rappresenta un concetto **generale**
	- creare classi **specializzate** che ereditano la classe + generale
- Terminologia
	- ==superclasse==: la classe da cui si ereditata
	- ==sottoclasse==: la classe derivata

>[!warning] Attenzione
>Non vengono **mai** ereditati variabili/metodi privati

### sintassi
- Si utilizza ```extends```
	- si può fare extends solo di **una** classe
```java
class Sottoclasse extends Superclasse {...}
```
### terminologia e notazione
- Termini **superclasse** e **sottoclasse** derivano dalla **teoria degli insiemi**
- Nel diagramma ereditarietà viene indicato con la freccia a punta triangolo vuoto
![[Diagramma ereditarietà.png|100]]
### metodi della sottoclasse
- Nella sottoclasse posso **sovrascrivere** dei metodi della superclasse
	- deve avere la **stessa firma**
- Invocare un metodo della superclasse
	- ```super.nomeMetodo(parametri)```
### variabili di instanza nella sottoclasse
- **Non** può essere sovrascritta una variabile di istanza nella sottoclasse
	- se ne creo due uguali, è come se creassi due variabili diverse
### costruttori nella sottoclasse
- Posso chiamare il costruttore della superclasse attraverso ```super()```
- Viene invocato automaticamente se non scritto esplicitamente
### conversione fra riferimenti
- Convertire da tipo **sottoclasse** a **superclasse*
	- la conversione avviene automaticamente
	- posso però solo usare i metodi del tipo che ho definito
- Conversione da tipo **superclasse** a tipo **sottoclasse**
	- NON avviene automaticamente
	- posso farla solo con un **cast**
		- se non si può fare: ```ClassCastException```
- Posso accettare come parametro un oggetto di tipo **superclasse**
	- e posso passare in quel metodo qualunque oggetto di una sua **sottoclasse**
### polimorfismo
- **Polimorfismo** = "molte forme"
	- il tipo **non determina in modo completo** il tipo dell'oggetto a cui essa si riferisce
- Ricorda: i types sono noti solo all'interprete di java, **non** in fase di **esecuzione**
	- il tipo di una variabile oggetto non influenza il contenuto della variabile oggetto stessa
	- l'esecuzione di un metodo ==è sempre determinata dal tipo dell'oggetto e non dal tipo della variabile oggetto==
- Esempio
	- creo metodo ```deposit``` nella superclasse e lo sovrascrivo nella sottoclasse
	- creo oggetto di tipo sottoclasse e poi lo converto nel tipo superclasse
	- chiamo metodo ```deposit```nell'oggetto creato e verrà usato quello della sottoclasse
#### early and late binding
- ==Selezione anticipata==
	- nel caso dell'overload, è il **compilatore** a scegliere quale metodo chiamare in base al **tipo**
	- tra diversi metodi di overload, viene sempre scelto quello più specifico
		- dove il compilatore deve fare meno conversioni
- ==Selezione posticipata==
	- avviene nel caso del polimorfismo
	- tra due metodi (superclasse, sottoclasse), a scegliere quale metodo chiamare è l'**interprete**
	- non può scegliere in base al tipo perché nel bytecode non sono presenti types
### operatore "instanceof"
- Verificare se una variabile di tipo superclasse è anche di tipo sottoclasse
	- buona pratica prima di effettuare un cast
```java
if (varOggetto instanceof NomeClasse) {
	...
}
```
### superclasse universale object
- Tutte le classi ereditano dalla superclasse universale ```Object```
- se ```extends```non viene indicato esplicitamente usa ```java.lang.Object```
#### metodi principali di object
![[Metodi classe object.png]]
#### metodo "to string"
- Metodo che viene invocato automaticamente quando si chiama ```println()```
- Di default, ```toString()``` restituisce ```NomeClasse@hashcode```
	- hashcode identifica indirizzo di memoria oggetto
- È utile sovrascrivere ```toString()```per restituire **informazioni di stato** dell'oggetto
	- ```return getClass().getName() + [informazioni]```
#### metodo "equals"
- Di default, ```equals(Object otherObject)```confronta indirizzi di memoria variabili oggetto
- È utile sovra-scriverlo per dare informazioni sulla coincidenza degli **stati degli oggetti**
	- es. confrontare "balance" di "BankAccount"
- Per sovrascriverlo, devo sempre usare come parametri nella firma ```Object otherObject```
### controllo di accesso
- 4 livelli
	- ```public```
	- ```package```
		- accesso all'interno del package
		- impostazione di default
	- ```protected```
		- accessibili alle sottoclassi
	- ```private```
### classi e metodi final
- Un metodo ```final```non può essere sovrascritto da sottoclassi
- Una classe ```final```non può avere sottoclassi
	- esempio: classe ```String```
### classi astratte
- Classi che definiscono i metodi senza implementarli
	- non posso creare un'istanza di una classe astratta direttamente
	- devo per forza implementare una classe astratta attraverso una sottoclasse
- Sintassi:
```java
public abstract class LaMiaClasseAstratta {
	public abstract ilMioMetodoAstratto area();
}
```
