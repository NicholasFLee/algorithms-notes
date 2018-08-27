class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public int size() { return size(root); }
    private int size(Node n) {
        if (n == null) return 0;
        else return n.N;
    }

    public Value get(Key key) { return get(root, key); }
    private Value get(Node n, Key key) {
        if (n == null) { return null; }
        if (n.key.compareTo(key) == 0) return n.value;
        else if (n.key.compareTo(key) < 0) return get(n.right, key);
        else return get(n.left, key);
    }

    public void put(Key key, Value value) { root = put(root, key, value); }
    private Node put(Node n, Key key, Value value) {
        if (n == null) return new Node(key, value, 1);
        if (n.key.compareTo(key) < 0) put(n.right, key, value);
        else if (n.key.compareTo(key) > 0) put(n.left, key, value);
        else n.value = value;
    }
}

public class C321 {

    
}