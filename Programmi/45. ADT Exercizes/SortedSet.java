public interface SortedSet extends Set {
    void add(Comparable obj);
    boolean contains(Comparable obj);
    Comparable[] toSortedArray();
}