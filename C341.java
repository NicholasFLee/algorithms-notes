class SeparateChainingHashST<Key, Value> {
    private int N;  // 键值对总数
    private int M;  // 散列表大小
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() { this(977); }
    public SeparateChainingHashST(int M) { 
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) st[i] = new SequentialSearchST();
    }

    private int hash(Key key) { return (key.hashCode() & 0x7fffffff) % M; }

    public Value get(Key key) { return (Value) st[hash(key)].get(key); }

    public void put(Key key, Value val) { st[hash(key)].put(key, val); }
}

public class C341 {
    public static void main(String[] args) {
        int hash = 17;
        String one = "10", two = "20", three = "30";
        hash = hash * 31 + one.hashCode();
        System.out.println(hash);
        System.out.println(hash % 17);
        hash = hash * 31 + two.hashCode();
        System.out.println(hash);
        System.out.println(hash % 17);
        hash = hash * 31 + three.hashCode();
        System.out.println(hash);
        System.out.println(hash % 17);
    }
}
