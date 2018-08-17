class ST<Key extends Comparable<Key>, Value> {
    public void put(Key k, Value v) {

    }

    public Value get(Key k) {
        return null;
    }

    public void delete(Key k) {

    }

    public boolean contains(Key k) {
        return get(k) != null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() { return 1; }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    public Key floor(Key k) {
        return null;
    }

    public Key ceilling(Key k) {
        return null;
    }

    public int rank(Key k) {
        return 0;
    }

    public Key select(int i) {
        return null;
    }

    public void deleteMin() {

    }

    public void deleteMax() {

    }

    public int size(Key lo, Key hi) {
        return 0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public Iterable<Key> keys() {
        return null;
    }
}

public class C311 {

    
}