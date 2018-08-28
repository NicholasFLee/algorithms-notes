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

    public Key select(int i) { return select(root, i).key; }
    private Node select(Node n, int i) {
        if (n == null) return null;
        int s = size(n.left);
        if (i > s) { return select(n.right, i - s - 1); }
        else if (i < s) { return select(n.left, i); }
        else return n;
    }

    public int rank(Key k) { return rank(k, root); }
    private int rank(Key k, Node n) {
        if (n == null) return 0;
        int cmp = k.compareTo(n.key);
        if (cmp < 0) { return rank(k, n.left); }
        else if (cmp > 0) { return 1 + size(n.left) + rank(k, n.right); }
        else return size(n.left);
    }

    public void deleteMin() { root = deleteMin(root); }
    private Node deleteMin(Node n) {
        if (n.left == null) return n.right;
        n.left = deleteMin(n.left);
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }

    public void delete(Key k) { root = delete(root, k); }
    private Node delete(Node n, Key k) {
        if (n == null) return null;
        int cmp = k.compareTo(n.key);
        if (cmp < 0) n.left = delete(n.left, k);
        else if (cmp > 0) n.right = delete(n.right, k);
        else {
            if (n.right == null) return n.left;
            if (n.left == null) return n.right;
            Node t = n;
            n = min(t.right);
            n.right = deleteMin(t.right);
            n.left = t.left;
        }
        n.N = size(n.left) + size(n.right) + 1;
        return n;
    }
}

public class C321 {
    public static void main(String[] args) {
        BSTTest();
    }

    public static void BSTTest() {
        BST<Integer, Integer> bst = new BST();
        bst.put(2, 19);
        bst.put(1, 18);
        bst.put(3, 20);
        System.out.println(bst.get(2));
        System.out.println(bst.size());
        System.out.println(bst.min());
        System.out.println(bst.floor(2));
        System.out.println(bst.select(2));
        System.out.println(bst.rank(2));
        bst.delete(2);
        System.out.println(bst.get(2));
    }
}
