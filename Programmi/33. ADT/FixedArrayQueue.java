public class FixedArrayQueue implements Queue {
    protected Object[] array;
    protected int front, back;
    public static final int INIT_SIZE = 100;

    public FixedArrayQueue() {
        array = new Object[INIT_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return back == front;
    }

    public void makeEmpty() {
        back = front = 0;
    }

    public void enqueue(Object obj) {
        if (back == array.length)
            throw new FullQueueException();
        array[back++] = obj;
    }

    public Object dequeue() {
        Object obj = getFront();
        front++;
        return obj;
    }

    public Object getFront() {
        if (isEmpty())
            throw new EmptyQueueException();
        return array[front];
    }
}
