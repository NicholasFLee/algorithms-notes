class SequentialSearchST<Key, Value> {
    private Node first;
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
    }
}

public class C311 {
    public static void main(String[] args) {
        sequentialSearchSTTest();
    }

    public static void sequentialSearchSTTest() {
        SequentialSearchST<String, Integer> sst = new SequentialSearchST();
        sst.put("first", 18);
        System.out.println(sst.get("first"));
    }
    
}