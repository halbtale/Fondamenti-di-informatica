import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main
{
	public static void main (String[] args)
	{
		// Creare un oggetto MiaPilaDiCode;
		MiaPilaDiCode pd = new MiaPilaDiCode();

		// Aprire e leggere il file input.txt;
		Scanner console = null;
		try
		{
			FileReader myFile = new FileReader("input.txt");
			console = new Scanner(myFile);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
			System.exit(1);
		}

		// Inserire ogni riga del file all’interno dell’oggetto MiaPilaDiCode precedentemente creato;
		while(console.hasNextLine())
		{
      		pd.push(console.nextLine());
		}

		// Estrarre tutti gli elementi inseriti nell’oggetto MiaPilaDiCode e mostrarli sull’output standard.
		while(!pd.isEmpty())
		{
      		System.out.print(pd.pop() + " ");
		}
	}
}