class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
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
}

public class C331 {
    public static void main(String[] args) {
    }
}