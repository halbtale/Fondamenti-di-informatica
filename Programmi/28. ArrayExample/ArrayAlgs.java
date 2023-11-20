public class ArrayAlgs {
    public static int[] resizeIntArray(int[] oldArray, int newLength) {
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
}
