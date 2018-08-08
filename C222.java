import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Quick {
    public static void sort(int[] a) {
        shuffleArray(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi) {
        // 将 a 分为 3 部分 [lo] < [i] < [hi]
        int i = lo, j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (v < a[--j]) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void shuffleArray(int[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}

public class C222 {
    public static void main(String[] args) {
    }
}