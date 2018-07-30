// Quick find
class QF {
    private int[] id;
    private int count;

    public QF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
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

// Quick Union
class QU {
    private int[] id;
    private int count;

    public QU(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
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

// Weighted Quick Union
class WQU {
    private int[] id;
    private int[] sz;
    private int count;

    public WQU(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        sz = new int[N];
        for (int i = 0; i < N; i++) sz[i] = i;
    }

    public int count() { return count; }

    public boolean connected(int p, int q) { return find(p) == find(q); }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p, int q) {
        if (connected(p, q)) return;
        int i = find(p);
        int j = find(q);
        if (sz[i] > sz[j]) { id[j] = i; sz[i] += sz[j]; } 
        else               { id[i] = j; sz[j] += sz[i]; }
        count--;
    }
}
public class C151 {
    public static void main(String[] args) {
        qfTest();
        quTest();
        wquTest();
    }

    public static void qfTest() {
        QF qf = new QF(10);
        qf.union(0, 2);
        qf.union(2, 3);
        qf.union(4, 5);
        System.out.println(qf.connected(0, 3));
        System.out.println(qf.connected(1, 4));
    }

    public static void quTest() {
        QU qu = new QU(10);
        qu.union(0, 2);
        qu.union(2, 3);
        qu.union(4, 5);
        System.out.println(qu.connected(0, 3));
        System.out.println(qu.connected(1, 4));
    }

    public static void wquTest() {
        WQU wqu = new WQU(10);
        wqu.union(0, 2);
        wqu.union(2, 3);
        wqu.union(4, 5);
        System.out.println(wqu.connected(0, 3));
        System.out.println(wqu.connected(1, 4));
    }
}