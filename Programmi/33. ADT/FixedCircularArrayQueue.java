public class FixedCircularArrayQueue extends FixedArrayQueue {
    protected int increment(int index) {
        return (index + 1) % array.length;
    }

    public void enqueue(Object obj) {
        if (increment(back) == front)
            throw new FullQueueException();
        array[back] = obj;
        back = increment(back);
    }

    public Object dequeue() {
        Object obj = getFront();
        front = increment(front);
        return obj;
    }
}
