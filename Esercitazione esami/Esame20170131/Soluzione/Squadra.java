public class Squadra extends Archivio
{
	public Squadra(){
		super();
		soldiDisponibili = 300;
	}

	public void inserisci (String chiave, int attributo)
	{
		if((soldiDisponibili - attributo >= 0) && (tagliaArchivio < 18))
		{
			super.inserisci(chiave, attributo);
			soldiDisponibili = soldiDisponibili - attributo;	
		}
	}

	public Coppia cancella(String chiave)
	{
		Coppia tmp = super.cancella(chiave);
		if (tmp != null)
			soldiDisponibili = soldiDisponibili + tmp.getAttributo();
		return tmp;
	}

	public int soldi()
	{
		return soldiDisponibili;
	}

	private int soldiDisponibili;
}