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
        int cmp = n.key.compareTo(key);
        if (cmp == 0) return n.value;
        else if (cmp < 0) return get(n.right, key);
        else return get(n.left, key);
    }

    public void put(Key key, Value value) { root = put(root, key, value); }
    private Node put(Node n, Key key, Value value) {
        if (n == null) return new Node(key, value, 1);
        int cmp = n.key.compareTo(key);
        if (cmp < 0) n.right = put(n.right, key, value);
        else if (cmp > 0) n.left = put(n.left, key, value);
        else n.value = value;
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }

    public Key min() { return min(root).key; }
    private Node min(Node n) {
        if (n == null) return null;
        if (n.left == null) { return n; }
        return min(n.left);
    }

    public Key floor(Key k) {
        Node n = floor(root, k);
        if (n == null) return null;
        return n.key;
    }
    private Node floor(Node n, Key k) {
        if (n == null) return null;
        int cmp = k.compareTo(n.key);
        if (cmp == 0) return n;
        else if (cmp < 0) return floor(n.left, k);
        Node t = floor(n.right, k);
        if (t != null) return t;
        else return n;
    }

}

public class C321 {
    public static void main(String[] args) {
        BSTTest();
    }

    public static void BSTTest() {
        BST<Integer, Integer> bst = new BST();
        bst.put(1, 18);
        bst.put(2, 19);
        bst.put(3, 20);
        System.out.println(bst.get(2));
        System.out.println(bst.size());
        System.out.println(bst.min());
        System.out.println(bst.floor(2));
    }
}
