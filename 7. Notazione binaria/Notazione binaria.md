## notazione binaria
### notazione posizionale
- Cifre uguali in **posizioni** diverse hanno significato diverso
- $4.34_{10} = (4·10^0 + 3·10^{-1} + 4·10^{-2})_{10}$
- $a_{n-1}a_{n-2}...a_0=\sum^{n-1}_{k=0}a_kb^k$
	- $n$ cifre
	- $b$ base
	- $a_k$ cifra in posizione k
### base binaria
- È la più semplice da manipolare per un computer
	- acceso/spento
	- tensione alta/bassa
#### conversione da binario a decimale
- $(1101)_2=(1*2^3+1*2^2+0*2^1+1*10^0)_{10}=(13)_{10}$
#### conversione da decimale a binario
- Parte intera elaborata in modo **indipendente** da quella frazionaria
- Conversione **parte intera**
	- $a_{k+1}=a_k÷2$ (ed elimino eventuale resto)
	- se $a_k=0$ mi fermo
	- risultato dato dalla serie dei resti iniziando dall'ultimo

![[Conversione da decimale a binario.png|200]]
- Conversione **parte frazionaria**
	- se $a_k>1$ -> $a_{k+1}=(a_k-1)*2$ 
	- se $a_k<1$ -> $a_{k+1}=a_k*2$
	- se parte decimale di $a_k=0$ oppure ad un risultato ottenuto in precedenza -> mi fermo 
	- risultato dato dalla serie delle parti intere partendo dal primo

![[Conversione da decimale a binario dopo virgola.png|200]]
### rappresentazione di numeri naturali
- 8 bit -> $2^8=256$ disposizioni
	- $0_{10}=0000\,0000_2$
	- $1_{10}=0000\,0001_2$
	- $2_{10}=0000\,0010_2$
	- ...
	- $255_{10}=1111\,1111_2$

> [!summary] In generale
> - rappresentazione n bit
> - si possono rappresentare $2^n$ numeri interi
> - $a\in[0, 2^{n}-1] \cap \mathbb{N}$
### rappresentazione di numeri interi relativi
#### Rappresentazione con modulo e segno
- Codifica
	- Primo **bit** (**+ significativo**): indica **segno**
		- 0 -> +
		- 1 -> -
	- Altri bit: indicano modulo del numero
- Esempio (8 bit)
	- $(0\,0001100)_2=(+12)_{10}$
	- $(1\,0001100)_2=(-12)_{10}$
- Due codifiche diverse per dire 0 (+0, -0) -> spreco
- Algoritmo di addizione -> troppo **lento** per una semplice somma

```
se (segno(A) == segno(B)):
	segno(S)=segno(A)
	|S|=(|A|+|B|)
altrimenti:
	se (|A| >= |B|):
		segno(S)=segno(A)
		|S|=|A|-|B|
	altrimenti:
		segno(S)=segno(B)
		|S|=|B|-|A|
```

> [!summary] In generale
> - rappresentazione a n bit
> - si possono rappresentare $2^n-1$ numeri interi
> - $a\in[-(2^{n-1}-1),+(2^{n-1}-1)] \cap \mathbb{Z}$

> [!warning] N.B.
> - Cifre più significative -> posizione a sinistra
> - Cifre meno significative -> posizione a destra
#### rappresentazione con complemento a due
- **Codifica**:
	- $a\geq0$
		- rappresentazione: $a$
	- $a<0$
		- rappresentazione: $(a+2^n)$
- Esempio (8 bit)
	- $(0111\,1111)_2=+127_{10}$
	- $(0000\,0001)_2=+1_{10}$
	- $(0000\,0000)_2=0_{10}$
	- $(1111\,1111)_2=255_{10}=>-1_{10}$
	- $(1000\,0000)_2=128_{10}=>-128_{10}$
- Procedimento per **conversione** da **decimale negativo a binario**
	- 1. modo
		- sommo al numero $2^n$ e poi converto 
	- 2. modo
		- codifico il modulo
		- scambio 0 con 1
		- sommo 1 al risultato
- Proprietà
	- **bit** più **significativo** rappresenta **segno**
	- solo **UNA** codifica per lo zero
- Addizione: si esegue **addizione binaria**
	- bisogna ignorare eventuale $(n+1)_{esima}$ cifra

![[Addizione binaria.png|500]]
> [!summary] In generale
> - rappresentazione a n bit
> - si possono rappresentare $2^n$ numeri interi
> - $a \in [-(2^{n-1}),+(2^{n-1}-1)] \cap \mathbb{Z}$

### errore di overflow
- Il numero è **più grande** della **codifica consentita**
#### overflow in addizione binaria
- Avviene se: $a+b\notin[-2^{n-1},+2^{n-1}-1]\cap\mathbb{Z}$
- Si può determinare analizzando le due cifre più significative del risultato
	- si ha **riporto** in **una sola** delle due cifre più significative

![[Errore di overflow.png|500]]
### rappresentazione in virgola fissa
- Il **separatore** si trova sempre nella **stessa posizione** rispetto alla sequenza dei bit
### numeri reali in virgola mobile
- Notazione a ==**mantissa ed esponente**==
- $1024.3=1.0243*10^3$
	- alcuni bit usati per la base
	- alcuni bit usati per l'esponente
- Computer utilizzano base 2
#### ieee 754
- Standard internazionale
- **Precisione singola **(32 bit)
	- 1 bit: segno
	- 8 bit: esponente con bias $e+127$
	- 23 bit: mantissa normalizzata (senza 1 iniziale)
- **Precisione doppia** (64 bit)
	- 1 bit: segno
	- 11 bit: esponente con bias $e+1023$
	- 52 bit: mantissa normalizzata (senza 1 iniziale)
- Numeri "**riservati**"
	- **0**
		- mantissa: 0
		- esponente: -127
	- **infinito**
		- mantissa = 0
		- esponente: +128
	- **NaN** 
		- mantissa ≠ 0
		- esponente: +128
- In codifica a 32 bit
	- Numero più piccolo: $1.8*10^{-38}$
	- Numero più grande: $3.4*10^{+38}$
	- Distanza tra due numeri reali rappresentabili: $\delta=2^{-23}*2^E$
		- $E$ = valore esponente
		- la distanza dipende dal valore dell'esponente
#### densità di numeri in virgola mobile
- Si può calcolare con:
- $\delta=2^{-m}\,*2^e$
	- m = bit mantissa
	- e = esponente

#### arrotondamento in virgola mobile
- Alcuni numeri decimali non hanno una rappresentazione esatta in binario
	- Es. 4.35
- Può causare errori nelle somme
### rappresentazione esadecimale
- Rappresentazione in **base 16**
	- $A=10_{10}$
	- $B=11_{10}$
	- $C=12_{10}$
	- $D=13_{10}$
	- $E=14_{10}$
	- $F=15_{10}$
- Conversione da binaria a esadecimale
	- $16=2^4$ -> raggruppo bit 4 a 4 **da destra**
- Esempio:
	- $0111\,1111_2=7F_{16}=0x7F$

### rappresentazione ottale
- Rappresentazione in **base 8**
- Conversione da binaria a ottale
	- $8=2^3$ -> raggruppo bit 3 a 3 **da destra**
- Esempio
	- $100\,010_2=42_8$

### rappresentazione di caratteri
- A ciascun carattere viene associato un numero naturale
- **ASCII** (American Standard Code for Information) - 7 bit
	- 128 caratter
		- alfabeto americano + numeri e simboli
- **ASCII esteso** - 8 bit
	- 256 caratteri
	- codifica tutti i caratteri dell'alfabeto occidentale
- **UNICODE** - 16bit
	- tutti i caratteri per tutte le lingue
	- i primi 7 bit corrispondono alla codifica ASCII