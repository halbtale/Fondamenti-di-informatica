
public class GrowingArrayStack extends FixedArrayStack {
    public void push(Object obj) {
        if (array.length == arraySize) {
            array = resize(2 * arraySize);
        }
        array[arraySize++] = obj;
    }

    protected Object[] resize(int newLength) // solita tecnica
    {
        if (newLength < array.length)
            throw new IllegalArgumentException();
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }
}
