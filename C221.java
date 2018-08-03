// 原地归并的抽象方法
class Merge {
    public void merge(int[] a, int lo, int mid, int hi) {
        // 先把 a 复制一份
        // int[] aux = new int[hi+1];
        // for (int i = 0; i <= hi; i++) {
        //     aux[i] = a[i];
        // }
        int[] aux = a.clone();
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
}

public class C221 {
    public static void main(String[] args) {
        
    }
}