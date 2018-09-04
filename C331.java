class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color; // is red

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node n) {
        if (n == null) return false;
        return n.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x; 
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node h) {
        if (h == null) return 0;
        return h.N; 
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }
    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;
        // 左黑 右红
        if (!isRed(h.left) && isRed(h.right)) h = rotateLeft(h);
        // 左红 左左红
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        // 左红 右红
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public boolean contains(Key key) { return contains(root, key); }
    private boolean contains(Node n, Key k) {
        if (n == null) return false;
        int cmp = k.compareTo(n.key);
        if (cmp < 0) return contains(n.left, k);
        else if (cmp > 0) return contains(n.right, k);
        else return true;
    }

    public Value get(Key key) {
        if (!contains(key)) return null;
        return get(root, key).val;
    }
    private Node get(Node n, Key k) {
        int cmp = k.compareTo(n.key);
        if (cmp < 0) return get(n.left, k);
        else if (cmp > 0) return get(n.right, k);
        else return n;
    }
}

public class C331 {
    public static void main(String[] args) {
        redBlackBSTTest();
    }
    public static void redBlackBSTTest() {
        RedBlackBST<Integer, Integer> bst = new RedBlackBST();
        bst.put(1, 1);
        bst.put(2, 2);
        System.out.println(bst.get(1));
    }
}