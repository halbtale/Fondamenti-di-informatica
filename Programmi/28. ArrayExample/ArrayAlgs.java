public class ArrayAlgs {
    public static int[] resize(int[] oldArray, int newLength) {
        if (newLength < 0 || oldArray == null)
            throw new IllegalArgumentException();

        int[] newArray = new int[newLength];
        int n = Math.min(oldArray.length, newLength);

        for (int i = 0; i < n; i++)
            newArray[i] = oldArray[i];

        return newArray;
    }

    public static int[] randomIntArray(int length, int n) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (n * Math.random());
        return a;
    }

    public static String printArray(int[] v, int vSize) {
        String s = "[";
        for (int i = 0; i < vSize; i++)
            s = s + v[i] + " ";

        s = s + "\b]";

        return s;
    }

    public static void remove(int[] v, int vSize, int index) {
        v[index] = v[vSize - 1];
    }

    public static void removeSorted(int[] v, int vSize, int index) {
        for (int i = index; i < vSize - 1; i++)
            v[i] = v[i + 1];
    }

    public static int[] insert(int[] v, int vSize, int index, int val) {
        if (vSize == v.length)
            v = resize(v, 2 * v.length);

        for (int i = vSize; i > index; i--)
            v[i] = v[i - 1];

        v[index] = val;
        return v;
    }

    public static int linearSearch(int[] v, int vSize, int value) {
        for (int i = 0; i < vSize; i++)
            if (v[i] == value)
                return i; // trovato valore

        return -1; // valore non trovato
    }

    public static int findMin(int[] v, int vSize) {
        int min = v[0];

        for (int i = 1; i < vSize; i++)
            if (v[i] < min)
                min = v[i];

        return min;
    }

    public static int findMax(int[] v, int vSize) {
        int max = v[0];

        for (int i = 1; i < vSize; i++)
            if (v[i] > max)
                max = v[i];

        return max;
    }
}
