// JAVA 中的两种继承机制 1, 接口继承的子类型. 2, 实现继承父类的子类.
// 如下有一个 `Play` 的接口, 内包含了一个方法的声明, `Man` 和 `Child` 可以实现这个方法.
interface Play {
    void play();
}

// 子类型
class Man implements Play {
    @Override
    public void play() {
        System.out.println("Man playing");
    }
}

// 子类型
class Child implements Play {
    @Override
    public void play() {
        System.out.println("Child playing");
    }
}

// 这个`Date`类型 继承了 `Object` 类. (JAVA 中所以的类都默认继承 Object 类)
class Date {
    // JAVA 中的类有可变类型和不可变类型
    // 这个 Date 类就是不可变类型, 前一个例子的 Counter 就是可变类型
    // 因为 Date 类的所有属性(状态)都是用 final 修饰的, 这表示这它们一旦被赋值就不能更改了.
    // 如果用 final 修饰一个引用类型的变量的话, 那么仅仅是这个引用不可以改变, 引用的对象还是可以改变的.
    private final int month, day, year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    // 因为这里的属性都是私有类型, 所以可以提供几个 public 方法获取属性的值.
    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    // 重写了从 `Object` 类继承的 toString 方法
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    // 重写了从 `Object` 类继承的 equals 方法
    public boolean equals(Object x) {
        if (this == x) return true; // 这一步会判断 this 和 x 的引用是不是相同
        if (x == null) return false; // 这一步判断参数是否是空
        if (this.getClass() != x.getClass()) return false; // 这一步判断是否是同一个类
        Date that = (Date) x; // 如果是同一个类自然可以把参数转化为 Date 类型
        if (this.day != that.day) return false; // 比较对象中的具体属性
        if (this.month != that.month) return false;
        if (this.year != that.year) return false;
        return true; // 对于不同的类, 比较相等有不同的定义, 在 Date 类型中, 判断 2 个对象是否相等的依据就是它们的属性值是否一致.
    }
}

public class C122 {
    public static void main(String[] args) {
        Play p1 = new Man();
        play(p1);

        Date d1 = new Date(6, 3, 1989);
        Date d2 = new Date(6, 4, 1989);
        // 在这里把 d2变量 引用的对象赋值给了 d1 变量, 那么原来 d1 变量所引用的对象就没有引用了, 这种对象被称为 `孤儿对象`. JAVA 中的 `垃圾回收` 会释放它的内存空间.
        d1 = d2;
        System.out.println(d1); // 6/4/1989
        
    }

    static void play(Play p) {
        p.play();
    }
}