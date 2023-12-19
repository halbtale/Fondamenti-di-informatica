public class FixedCircularArrayDeque implements Deque {
    private Object[] array;
    private int front;
    private int back;
    private final static int INIT_SIZE = 10;

    private int increment(int currentIndex) {
        return (currentIndex + 1) % array.length; 
    }

    private int decrement(int currentIndex) {
        if (currentIndex > 0) return (currentIndex - 1) % array.length; 
        else return (currentIndex - 1 + array.length) % array.length;
    }

    public FixedCircularArrayDeque() {
        array = new Object[INIT_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return front == back;
    }
    public void makeEmpty() {
        front = back = 0;
    }

    public Object getFirst() {
        return array[front];
    }
    public Object getLast() {
        return array[decrement(back)];
    }

    public void addFirst(Object obj) {
        front = decrement(front);
        array[front] = obj;
    }

    public void addLast(Object obj) {
        array[back] = obj;
        back = increment(back);
    }

    public Object removeFirst() {
        Object first = array[front];
        front = increment(front);
        return first;
    }
    public Object removeLast() {
        Object last = array[back];
        back = decrement(back);
        return last;
    }

    public int size() {
        return Math.abs(back - front);
    }

    public String toString() {
        String s = "[";
        if (back > front) {
            for (int i = 0; i<back && i>=front; i++) {
                s += array[i] + ", ";
            }
        } else if (back < front) {
            for (int i = front; i < array.length; i++) {
                s += array[i] + ", ";
            }
            for (int i = 0; i < back; i++) {
                s += array[i] + ", ";
            }
        } else {
            s+="  ";
        }
        s+="\b\b]";
        s+=", front="+front;
        s+=", back="+back;
        return s;
    }
}