package corso33;

public class GrowingCircularArrayQueue extends FixedCircularArrayQueue {
    public void enqueue(Object obj) {
        if (increment(back) == front) {
            array = resize(2 * array.length);
            if (back < front) {
                System.arraycopy(array, 0, array, array.length / 2, back);
                back += array.length / 2;
            }
        }
        array[back] = obj;
        back = increment(back);
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
