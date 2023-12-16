package corso33;

public class FixedArrayStack implements Stack {
    public final static int INIT_SIZE = 100;
    protected Object[] array;
    protected int arraySize = 0;

    public FixedArrayStack() {
        array = new Object[INIT_SIZE];
        makeEmpty();
    }

    public boolean isEmpty() {
        return arraySize == 0;
    }

    public void makeEmpty() {
        arraySize = 0;
    }

    public void push(Object obj) {
        if (arraySize == array.length)
            throw new FullStackException();
        array[arraySize++] = obj;
    }

    public Object top() {
        if (isEmpty())
            throw new EmptyStackException();
        return array[arraySize - 1];
    }

    public Object pop() {
        Object obj = top();
        arraySize--;
        return obj;
    }
}
