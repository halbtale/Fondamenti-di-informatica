/*
Nome: Alberto
Cognome: Heissl
Numero di matricola: 2101739
Numero della postazione: Mac
*/

import java.util.Scanner;

public class AnalisiMisure
{
    public static void main(String[] args)
    {
        log(" Benvenuto!");

        final int INIT_MEASURE_SIZE = 5;
        double[] measures = new double[INIT_MEASURE_SIZE];
        int measuresSize = 0;
        
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            try {
                double measure = promptForMeasure(in);
                if (measuresSize == measures.length) measures = resizeDoubleArray(measures);
                measures[measuresSize++] = measure;
            } catch (NumberFormatException e) {
                log("Il formato del numero inserito non e' valido", true);
            } catch (NegativeMeasureException e) {
                log("La misura inserita e' negativa quindi non valida", true);
            }
        }
        in.close();

        double[] measureStats = getMeasureStats(measures, measuresSize);

        log("La media e': "+measureStats[0]);
        log("La derivazione standard e': "+measureStats[1]);
    }

    private static double promptForMeasure(Scanner in) {
        String measureRaw = in.nextLine();
        double measure = Double.parseDouble(measureRaw);
        if (measure < 0) throw new NegativeMeasureException();
        return measure;
    }

    private static double[] resizeDoubleArray(double[] doubleArray) {
        double[] newDoubleArray = new double[doubleArray.length * 2];
        System.arraycopy(doubleArray, 0, newDoubleArray, 0, doubleArray.length);
        return newDoubleArray;
    }

    private static double[] getMeasureStats(double[] measures, int measuresSize) {
        double[] results = new double[] {0, 0};
        if (measuresSize == 0) return results;

        double sum = 0;
        double squareSum = 0;
        for (int i = 0; i<measuresSize; i++) {
            sum += measures[i];
            squareSum += Math.pow(measures[i], 2);
        }
        double average = sum / measuresSize;
        double derivation = measuresSize > 1 ? Math.sqrt((squareSum - sum*sum/measuresSize)/(measuresSize-1)) : 0;
        results[0] = average;
        results[1] = derivation;
        return results;
    }

    private static void log(String message) {
        log(message, false);
    }

    private static void log(String message, boolean isWarn) {
        if (isWarn) System.out.print("\u001B[33m [Warn] ");
        else System.out.print("\u001B[0m [Info] ");
        System.out.println(message);
    }
}

class NegativeMeasureException extends RuntimeException { }