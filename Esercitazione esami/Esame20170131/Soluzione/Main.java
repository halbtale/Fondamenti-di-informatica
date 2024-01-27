import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Archivio mioArchivio = new Archivio();
		Tester.testArchivio(mioArchivio);
		
		/* Leggere il file fantacalcio.txt e inserire tutte le righe nell'archivio */
		Scanner mioScanner = null;
		try
		{
			FileReader mioFile = new FileReader("fantacalcio.txt");
			mioScanner = new Scanner(mioFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
			System.exit(1);
		}

		while(mioScanner.hasNextLine())
		{
			String[] tmp = mioScanner.nextLine().split(":");
      		mioArchivio.inserisci(tmp[0], Integer.parseInt(tmp[1]));
		}

		/* Stampare l'archivio */
		System.out.println("Stampa mioArchivio:");
		System.out.println(mioArchivio.toString());
		
		/* Creare un oggetto miaSquadra di tipo Squadra*/
		Squadra miaSquadra = new Squadra();
		
		/*Da decommentare solo dopo aver passato il primo test e aver completato i punti precedenti*/
		Tester.testCompleto(mioArchivio, miaSquadra);

		/* Stampare l'oggetto miaSquadra */
		System.out.println("Stampa miaSquadra:");
		System.out.println(miaSquadra.toString());	
	}
}