class MaxPQ {
    private int[] pq;

    private int N = 0;

    public MaxPQ(int maxN) {
        pq = new int[maxN + 1];
    }

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMax() {
        int max = pq[1];
        exch(1, N--);
        sink(1);
        return max;
    }

    public void swim(int i) {
        while (i > 1 && pq[i] > pq[i/2]) {
            exch(i, i/2);
            i /= 2;
        }
    }

    public void sink(int i) {
        while (2*i <= N) {
            int j = 2*i;
            if (j < N && pq[j] < pq[j+1]) { j++; } // Get bigger child
            if (pq[i] >= pq[j]) break; // if greater than child, break
            exch(i, j);
            i = j;
        }
    }

    private void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    @Override
    public String toString() {
        String res = "";
        for (int i : pq) {
            res = res + i + " ";
        }
        return res;
    }

}

public class C241 {
    public static void main(String[] args) {
        maxPQTest();
    }

    public static void maxPQTest() {
        MaxPQ mp = new MaxPQ(10);
        mp.insert(2);
        mp.insert(4);
        mp.insert(3);
        mp.insert(1);
        System.out.println(mp);
    }
}
