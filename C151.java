class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() { return count; }

    public boolean connected(int p, int q) { return id[p] == id[q]; }

    public int find(int p) { return id[p]; }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        for (int i = 0; i < count; i++) {
            if (id[i] == q) id[i] = id[p];
            System.out.println(id[i]);
        }
    }
}

public class C151 {
    public static void main(String[] args) {
        UF uf = new UF(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(4, 5);
        System.out.println(uf.connected(1, 3));
        System.out.println(uf.connected(1, 4));
    }
}