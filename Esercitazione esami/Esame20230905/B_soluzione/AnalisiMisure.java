/*
Nome:
Cognome:
Numero di matricola:
Numero della postazione: 
*/

import java.util.Scanner;

public class AnalisiMisure
{
    public static void main(String[] args)
    {
        double sum = 0;
        double sumSquares = 0;
        int count = 0;

        Scanner in = new Scanner(System.in);
        boolean done = false;

        while (!done)
        {
            System.out.println("Inserire numero (Q per terminare sequenza):");
            String newInput;
            if (!in.hasNextLine() || 
              (newInput=in.nextLine()).equalsIgnoreCase("Q"))
                done = true;
            else
            {
                try
                {
                    double newNumber = Double.parseDouble(newInput);
                    sum += newNumber;
                    sumSquares += newNumber * newNumber;
                    count++;
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Input non valido!");
                }
            }
        }

        double avrg = 0;
        double stdev = 0;
        if (count > 0)
        {  
            avrg = sum / count;
            if (count == 1)
                stdev = 0;
            else
                stdev = Math.sqrt((sumSquares - sum*sum/count) / (count - 1));
        }

        System.out.println("Hai inserito " + count + " elementi.");
        System.out.println("La media è: " + avrg);
        System.out.println("La deviazione standard è: " + stdev); 
    }
}