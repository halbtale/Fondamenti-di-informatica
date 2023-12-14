public interface Dictionary extends Container {
    void insert(Comparable key, Object value);

    void remove(Comparable key);

    Object find(Comparable key);
}

class DictionaryItemNotFoundException extends RuntimeException {
};
