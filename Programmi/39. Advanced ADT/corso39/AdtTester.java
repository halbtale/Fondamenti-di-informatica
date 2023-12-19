public class AdtTester {
    public static void main(String[] args) {
        Deque deque = new FixedCircularArrayDeque();

        deque.addFirst("Z");
        System.out.println(deque);

        deque.addFirst("X");
        System.out.println(deque);

        deque.addLast("A");
        System.out.println(deque);

        deque.addLast("B");
        System.out.println(deque);

        deque.addLast("C");
        System.out.println(deque);

        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
    }
}