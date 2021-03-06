// 自顶向下归并排序
class Merge {
    public static void sort(int[] a) {
        sort(a, a.clone(), 0, a.length - 1);
    }

    private static void sort(int a[], int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        // 把数组分为 2 块
        // 每一块递归到最后 sort(a, 0, 1)
        // 然后排序 merge(a, 0, 0, 1)
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        // 最后再把 2 个排序好的数组排序
        aux = a.clone();
        merge(a, aux, lo, mid, hi);
    }

    // 原地归并的抽象方法
    public static void merge(int[] a, int[]aux, int lo, int mid, int hi) {
        // [i...mid] 是第一个子数组
        int i = lo;
        // [mid+1...hi] 是第二个子数组
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // 如果第一个数组用完了, 直接取第二个数组
            if (i > mid) a[k] = aux[j++];
            // 如果第二个数组用完了, 直接取第一个数组
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i] <= aux[j]) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
        }
    }
}

public class C221 {
    public static void main(String[] args) {
        mergeSortTest();
    }

    public static void mergeSortTest() {
        int[] a = {4, 3, 0, 5, 2, 1};
        Merge.sort(a);
        for (int v : a) {
            System.out.println(v);
        }
    }
}
