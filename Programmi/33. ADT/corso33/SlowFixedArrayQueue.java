
public class SlowFixedArrayQueue implements Queue {
    protected Object[] array;
    protected int arraySize;
    public static final int INIT_SIZE = 100;

    public SlowFixedArrayQueue() {
        array = new Object[INIT_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return arraySize == 0;
    }

    public void makeEmpty() {
        arraySize = 0;
    }

    public void enqueue(Object obj) {
        if (arraySize == array.length)
            throw new FullQueueException();
        array[arraySize++] = obj;
    }

    public Object dequeue() {
        Object obj = getFront();
        arraySize--;
        for (int i = 0; i < arraySize; i++) {
            array[i] = array[i + 1];
        }
        return obj;
    }

    public Object getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        return array[0];
    }
}
