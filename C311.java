import java.util.Iterator;

class SequentialSearchST<Key, Value> {
    private Node first;
    private int N = 0;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key k, Value v, Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
    }

    private class KeyIterator implements Iterator<Key> {
        private Node n = first;
        @Override
        public boolean hasNext() {
            return n != null;
        }

        @Override
        public Key next() {
            Key res = n.key;
            n = n.next;
            return res;
        }
    }

    public Value get(Key k) {
        for (Node x = first; x != null; x = x.next)
            if (x.key.equals(k)) return x.val;
        return null;
    }

    public void put (Key k, Value v) {
        for (Node x = first; x != null; x = x.next)
            if (x.key.equals(k)) {
                x.val = v; 
                return; 
            }
        first = new Node(k, v, first);
        N++;
    }

    public int size() {
        return N;
    }

    public Iterator keys() {
        return new KeyIterator();
    }

    public void delete(Key k) {
        Node last = null;
        for(Node n = first; n != null; n = n.next) {
            if (n.key.equals(k)) {
                if (last != null) {
                    last.next = n.next;
                } else {
                    first = n.next;
                }
                return;
            }
            last = n;
        }
    }

    @Override
    public String toString() {
        String res = "";
        Iterator<Key> itr = keys();
        while (itr.hasNext()) {
            Key k = itr.next();
            res = res + k + " -> ";
            res = res + get(k) + ".\n";
        }
        return res;
    }
}

class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public int rank(Key k) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = k.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) hi = mid + 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key k) {
        if (N == 0) return null;
        int i = rank(k);
        if (i < N && keys[i].compareTo(k) == 0) return vals[i];
        else return null;
    }

    public void put(Key k, Value v) {
        int i = rank(k);
        if (i < N && keys[i].compareTo(k) == 0) {
            vals[i] = v;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = k;
        vals[i] = v;
        N++;
    }

    public void delete(Key k) {
        if (N == 0) return;
        int i = rank(k);
        keys[i] = null;
        vals[i] = null;
        N--;
    }
}


public class C311 {
    public static void main(String[] args) {
        // sequentialSearchSTTest();
        binarySearchSTTest();
    }

    public static void sequentialSearchSTTest() {
        SequentialSearchST<String, Integer> sst = new SequentialSearchST();
        sst.put("first", 18);
        sst.put("second", 18);
        sst.put("trois", 19);
        System.out.println(sst);
    }

    public static void binarySearchSTTest() {
        BinarySearchST<String, Integer> bst = new BinarySearchST(10);
        bst.put("li", 18);
        bst.put("ly", 19);
        System.out.println(bst.get("li"));
        System.out.println(bst.get("ly"));
    }
    
}
