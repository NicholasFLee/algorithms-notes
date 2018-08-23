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

public class C311 {
    public static void main(String[] args) {
        sequentialSearchSTTest();
    }

    public static void sequentialSearchSTTest() {
        SequentialSearchST<String, Integer> sst = new SequentialSearchST();
        sst.put("first", 18);
        sst.put("second", 18);
        sst.put("trois", 19);
        System.out.println(sst);
    }
    
}
