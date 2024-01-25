/**
  * Classe MIS
  * rappresenta un campione di una misura
  *
  * NOME E COGNOME CANDIDATO: Alberto Heissl
  * MATRICOLA: 2101739
  * DATA: 30/01/2024
  * POSTAZIONE: 10
  *
  */
public class MIS implements Comparable
{
	//parte privata
	private int t;
	private double v;

	// parte pubblica
	public MIS(int t, double v) {
		this.t = t;
		this.v = v;
	}

	public int tempo() {
		return t;
	}

	public double valore() {
		return v;
	}

	public String toString() {
		return String.format("(%d %.1f)", t, v);
	}

	public int compareTo(Object obj) {
		if (obj instanceof MIS) {
			MIS otherMis = (MIS) obj;
			return this.t - otherMis.t;
		} else {
			throw new IllegalArgumentException("obj must be of type MIS");
		}
	}
}