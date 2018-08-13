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
        pq[N+1] = null;
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

    private exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}

public class C241 {

    
}