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

    public void deleteMin() { delete(min()); }

    public void deleteMax() { delete(max()); }

    public int size(Key lo, Key hi) {
        return 0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) { return 0; }
        else if (contains(hi)) { return rank(hi) - rank(lo) + 1; }
        else return rank(hi) - rank(lo);
    }

    public Iterable<Key> keys() { return keys(min(), max()); }
}

public class C311 {

    
}