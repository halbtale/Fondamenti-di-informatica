// Alberto Heissl 2101739

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main
{
	public static void main(String args[])
	{
		Archivio mioArchivio = new Archivio();
		Tester.testArchivio(mioArchivio);
		
		/* Leggere il file fantacalcio.txt e inserire tutte le righe nell'archivio */
		populateArchivioFromFile(mioArchivio);

		/* Stampare l'archivio */
		System.out.println(mioArchivio);
		
		/* Creare un oggetto miaSquadra di tipo Squadra*/
		Squadra miaSquadra = new Squadra();
			
		/*Da decommentare solo dopo aver passato il primo test e aver completato i punti precedenti*/
		Tester.testCompleto(mioArchivio, miaSquadra);
		
		/* Stampare l'oggetto miaSquadra */
		System.out.println(miaSquadra);
	}

	private static void populateArchivioFromFile(Archivio mioArchivio) {
		try (FileReader reader = new FileReader("fantacalcio.txt")) {
			Scanner in = new Scanner(reader);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				Scanner scan = new Scanner(line);
				scan.useDelimiter(":");
				mioArchivio.inserisci(scan.next(), Integer.parseInt(scan.next()));
				scan.close();
			}

			in.close();
		} catch (IOException e) {
			System.err.println("Si e' verificato un errore nella lettura del fine input");
			System.exit(1);
		}
		
	}
}