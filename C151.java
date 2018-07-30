// Union find
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

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public int find(int p) { return id[p]; }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        for (int i = 0; i < count; i++) {
            if (id[i] == id[q]) id[i] = id[p];
        }
        count--;
    }
}

// Quick find
class QF {
    private int[] id;
    private int count;

    public QF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() { return count; }

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        id[find(p)] = find(q);
        count--;
    }
}

public class C151 {
    public static void main(String[] args) {
        ufTest();
        qfTest();
    }

    public static void ufTest() {
        UF uf = new UF(10);
        uf.union(0, 2);
        uf.union(2, 3);
        uf.union(4, 5);
        System.out.println(uf.connected(0, 3));
        System.out.println(uf.connected(1, 4));
    }

    public static void qfTest() {
        QF qf = new QF(10);
        qf.union(0, 2);
        qf.union(2, 3);
        qf.union(4, 5);
        System.out.println(qf.connected(0, 3));
        System.out.println(qf.connected(1, 4));
    }
}