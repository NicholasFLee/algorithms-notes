class ST<Key extends Comparable<Key>, Value> {
    void put(Key k, Value v) {

    }

    Value get(Key k) {
        return null;
    }

    void delete(Key k) {

    }

    boolean contains(Key k) {
        return get(k) != null;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() { return 1; }

    Key min() {
        return null;
    }

    Key max() {
        return null;
    }

    Key floor(Key k) {
        return null;
    }

    Key ceilling(Key k) {
        return null;
    }

    int rank(Key k) {
        return 0;
    }

    Key select(int i) {
        return null;
    }

    void deleteMin() {

    }

    void deleteMax() {

    }

    int size(Key lo, Key hi) {
        return 0;
    }

    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    Iterable<Key> keys() {
        return null;
    }
}

public class C311 {

    
}