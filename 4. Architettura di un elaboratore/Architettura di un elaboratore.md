## architettura di un elaboratore
### il modello di john von neumann
- Primo documento che descrive l'architettura di un computer
	![[Architettura.png|650]]
- Vantaggi: 
	- **semplicità**
	- **flessibilità**: si possono aggiungere tanti elementi senza modificare dispositivo di base
	- **standardizzabilità**: regole precise di comunicazione tra dispositivi diversi
- Svantaggi
	- **lentezza**: presenza di un unico BUS
	- **limitata capacità**: al crescere del numero di dispositivi collegati
	- **sovraccarico del processore**: tutto va al processore
#### bus presenta in realtà 3 bus distinti
- Bus dei **dati**
	- i dati da trasferire
- Bus degli **indirizzi**
	- dove i dati devono andare
- Bus dei **segnali di controllo**
	- segnali di stop, reset, etc
### cpu
- **Central Processing Unit**
- Funzioni
	- individua ed esegue le istruzioni del programma
	- esegue elaborazioni aritmetiche e logiche
	- reperisce i dati dalla memoria e li rispedisce dopo averli elaborati
- Costituito da più CORE
	- permette operazioni parallele
#### chip della cpu
- Circuito integrato
	- connettori metallici esterni (pin)
	- collegamenti interni (wire)
	- costituito da silicio
	- package: contenitore plastico o ceramico
- Costituito da tre parti
	- **ALU** (Arithmetic-Logic Unit)
		- esegue elaborazioni aritmetiche e logiche
	- **unità di controllo**
		- governa il traffico dati
	- **registri di memoria**
		- memoria temporanea velocissima
#### clock
- Funzionamento della CPU è **ciclico**
	- **fetch**
		- legge da memoria e memorizza su registro
	- **decode**
		- decodifica istruzione da eseguire
	- **execute**
		- esegue istruzione
- La frequenza del clock è limitata dalla tecnologia disponibile
- **Program Counter**
	- registro speciale
	- contiene la posizione dell'istruzione a cui si accede durante la fase di fetch
	- incrementato di un'unità ad ogni ciclo
		- permette di eseguire istruzioni in sequenza
#### parallelismo
- **Parallelismo a livello delle istruzioni**
	- architettura **pipeline** o **superscalare**
	- come una catena di montaggio
	- pipeline a 5 stadi (tutti gli stadi avvengono contemporaneamente)
		- S1. lettura delle istruzioni
		- S2. decodifica dell'istruzione
		- S3. individuazione e recupero degli operandi
		- S4. esecuzione dell'istruzione
		- S5. invio dei risultati dell'apposito registro
- **Parallelismo a livello di processori**
	- computer **multiprocessori**
	- **multicalcolatori** (+ computer contemporaneamente)
#### programmazione parallela su gpu
- **CUDA**
	- ambiente di sviluppo in parallelo per GPU
- Elaborazioni intensive che sfruttano questo tipo di architetturre
	- Linear algebra
	- FFTs (Signal and image processing)
	- Machine Learning
### memoria del computer
- Suddivisa in celle (o locazioni di memoria)
	- ciascuna ha un indirizzo
	- ciascuna cella contiene un numero definito di bit
![[Gerarchie di memoria.png|700]]
#### spazio di indirizzamento
- Indirizzo -> sequenze di bit
- Sistemi operativi a 16bit, 32bit, 64bit
	- da cui dipende la lunghezza degli indirizzi -> RAM massima
#### memoria primaria (o centrale)
- Veloce ma costosa
- Chip di memoria 
- **ROM** (Read-Only Memory)
	- sola lettura
	- progettata per essere sempre disponibile
	- memorizzato il BIOS (Basic Input/Output System)
	- più tipi di ROM
		- PROM (Programmable ROM)
		- EPROM (Erasable PROM)
		- EEPROM (Electrical EPROM) -> permette multiple scritture
- **RAM** (Random Access Memory)
	- lettura e scrittura
	- accesso casuale -> si può leggere qualunque cella nello stesso tempo
	- volatile -> quando spegni il computer si cancella
	- utilizzata dai programmi in esecuzione
	- più tipi di RAM
		- SRAM (Static RAM)
		- DRAM (Dynamic RAM)
		- SDRAM (Syncronous DRAM)
		- DDR1-DDR5 (Double Data Rate)
	- packaging
		- SIMM (Single Inline Memory Module) -> connettori 1 lato
		- DIMM (Dual Inline Memory Module) -> connettori 2 lati
- **Cache**
	- memoria + veloce della RAM ma più piccola
	- algoritmi statistici prevedono quali istruzioni potrebbero essere eseguite in seguito
	- località spaziale
		- quando si caricano dei dati dalla RAM
		- sulla cache vengono messi i dati vicini a quelli
	- località temporale
		- se carico un dato dalla RAM, potrebbe essere richiesto più volte
		- viene caricato dalla cache
#### memoria secondaria
- Supporto di memoria NON volatile
- + lenta e + economica della memoria primaria
- **Hard Disk**
	- piatti roteanti rivestiti di materiale magnetico
	- presenza di una testina che legge il disco
	- lettura/scrittura elettromagnetica - funzionamento meccanico
	- formattazione = assegnare degli indirizzi alle varie parti dell'hard disk
	- + economica
- **SSD**
	- memoria stato solido (memoria flash)
	- NO parti meccaniche in movimento
	- + veloce e + costosa
- **Nastri magnetici**
	- tipologie: LTO, DLT
	- + capacità e + robusto -> usati per backup
- **CD** (Compact Disk)
	- laser brucia fori -> cunette e assenza cunette -> codice binario
### input/output - modalità
- **Controllo di programma**
	- esamina periodicamente lo stato dell'interfaccia hardware (polling)
- **Interrupt**
	- es. Control Alt Canc
	- dispositivo notifica il suo comportamento alla CPU
- **DMA** (Direct Memory Access)
	- possibilità di comunicare alla memoria senza BUS
![[INPUT OUTPUT.png]]
### le porte (o interfacce)
- Collegamento fisico
	- attaccate alla scheda madre
	- "prese" a cui si collegano i dispositivi
- Si dividono in
	- periferiche esterne
		- maneggiabili dall'utente
	- periferiche interne
- Si differenziano per
	- quantità di informazioni che lasciano passare
	- velocità
#### porte standard
- Non più in uso
	- Interfaccia Seriale
	- Interfaccia Parallela
- **USB** (Universal Serial BUS)
	- + versioni (1.0, 2.0, 3.0, 3.1, 3.2, 4)
### periferiche esterne
#### input
- **Mouse**
	- manda segnali al processore
		- pressione di un tasto
		- rilascio di un tasto
		- spostamento rispetto alla posizione precedente
	- informazione viene elaborata e tradotta
	- altri dispositivi di puntamento
		- Trackball
		- Touchpad
		- Airmouse
		- Trackpoint
- **Tastiera**
	- genera segnale **interrupt**
	- segnale elaborato e trasformato
		- in un carattere
		- in un segnale di stato
- **Scanner/Fotocamera**
	- produce bitmap
	- risoluzione di scansione
		- misura in DPI (punti per pollice)
#### output
- **Monitor**
	- LCD (Liquid Crystal Display)
		- emette luce bianca -> eccita cristalli liquidi -> da esso dipende colore pixel
		- tutti i pixel si accendono
	- OLED
		- pixel eccitati da elettricità
		- campo elettrico modifica allineamento molecolare dei cristalli -> proprietà ottiche
		- nero = assenza di luce -> pixel spenti
- **Stampanti**
	- ad aghi
	- ad inchiostro
	- laser
	- 3D
- **Scheda audio**
	- trasforma informazioni digitali in suoni
	- la qualità dipende dalla frequenza di campionamento e dalla precisione del clock
- **Rete**
	- scambiare segnali in ingresso e uscita
### scheda madre
- Base su cui sono montati CPU e RAM

> [!question] Domande
> - Dove viene memorizzato un programma che non sia attualmente in esecuzione?
> - Quale parte del computer esegue le operazioni aritmetiche, come addizioni e moltiplicazioni?
