// 自顶向下归并排序
class Merge {

    private static int[] aux;

    // 原地归并的抽象方法
    public static void merge(int[] a, int lo, int mid, int hi) {
        // 先把 a 复制一份
        aux = a.clone();
        // [i...mid] 是第一个子数组
        int i = lo;
        // [mid+1...hi] 是第二个子数组
        int j = mid + 1;
        for (int k = 0; k <= hi; k++) {
            // 如果第一个数组用完了, 直接取第二个数组
            if (i > mid) a[k] = aux[j++];
            // 如果第二个数组用完了, 直接取第一个数组
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] <= aux[j]) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
        }
    }

    public static void sort(int[] a) {
        // aux = a.clone();
        sort(a, 0, a.length - 1);
    }

    private static void sort(int a[], int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }
}

public class C221 {
    public static void main(String[] args) {
        mergeTest();
    }

    public static void mergeTest() {
        int[] a = {1, 3, 5, 0, 2, 4};
        Merge.merge(a, 0, 2, 5);
        for (int v : a) {
            System.out.println(v);
        }
    }
}
