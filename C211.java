// 在 java 中, 实现了 Comparable 的类, 就可以将其排序
class Date implements Comparable<Date> {
    private final int day, month, year;

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public int compareTo(Date that) {
        if (this.year > that.year) return 1;
        if (this.year < that.year) return -1;
        if (this.month > that.month) return 1;
        if (this.month < that.month) return -1;
        if (this.day > that.day) return 1;
        if (this.day < that.day) return -1;
        return 0;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }
}

// 2.1 选择排序
class Selection {
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (a[j] < a[min]) min = j;
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }
}

// 2.2 插入排序
class Insertion {
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
}

public class C211 {
    public static void main(String[] args) {
        // selectionTest();
        insertionTest();
    }

    public static void insertionTest() {
        int[] a = {3, 2, 1, 4};
        Insertion.sort(a);
        System.out.println(a[0]);
    }

    public static void selectionTest() {
        int[] a = {3, 2, 1, 4};
        Selection.sort(a);
        System.out.println(a[0]);
    }

    public static void dateTest() {
        Date d1 = new Date(1, 2, 2006);
        Date d2 = new Date(1, 2, 2008);
        System.out.println(d2.compareTo(d1));
    }
}