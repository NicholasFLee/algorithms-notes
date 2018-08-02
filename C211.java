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

public class C211 {
    
}