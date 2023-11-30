public class ArrayAlgs {
    public static String[] resize(String[] oldArray, int newLength) {
        if (newLength < 0 || oldArray == null)
            throw new IllegalArgumentException();

        String[] newArray = new String[newLength];
        int n = Math.min(oldArray.length, newLength);

        for (int i = 0; i < n; i++)
            newArray[i] = oldArray[i];

        return newArray;
    }

}
