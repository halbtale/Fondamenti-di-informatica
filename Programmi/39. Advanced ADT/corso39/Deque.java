public interface Deque {
    Object getFirst();
    Object getLast();

    void addFirst(Object obj);
    void addLast(Object obj);

    Object removeFirst();
    Object removeLast();

    int size();
}