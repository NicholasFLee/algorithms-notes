class LinearProbingHashST<Key, Value> {
    private int N; // 键值对
    private int M = 16; // 数组长度
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) { return (key.hashCode() & 0x7fffffff) % M; }

    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) { vals[i] = val; return; }
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) { return vals[i]; }
        }
        return null;
    }
}

public class C342 {
    public static void main(String[] args) {
        LinearProbingHashST<Integer, Integer> st = new LinearProbingHashST();
        st.put(1, 2);
        System.out.println(st.get(1));
    }
}