
public class GrowingArrayQueue extends FixedArrayQueue {
    public void enqueue(Object obj) {
        if (back == array.length)
            array = resize(2 * array.length);
        array[back++] = obj;
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
