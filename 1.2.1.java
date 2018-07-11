// 抽象数据类型 Counter
class Counter {
    
    // 私有的 2 个实例变量, 也就是对象的`状态`
    // 数字原始类型的原始值是 0, bool 类型是 false, 引用类型是 null,
    // 例如下方 count 的原始值是 0, name 是 null.
    private int count;
    // final 表示这个值在初始化之后不应该改变.
    private final String name;

    // 类型的构造函数
    // 构造函数的名称和类一样, 后面可以跟参数.
    public Counter(String name) {
        // 实例变量: this.name, 参数变量: name
        this.name = name;
    }
    
    // 两个公有实例方法, 也就是对象的`行为`, 在实例方法中可以用 `this` 访问对象本身.
    // 把 count 的值加一
    public void increment() {
        this.count++;
    }

    // 返回 count 的值
    public int tally() {
        return this.count;
    }

    // 自动继承的 toString(), 通过重载让它变的更实用.
    public String toString() {
        return "counter " + this.name + " is " + this.count;
    }

    /**
     * 用例
     * 一般实现一个数据类型之后, 要为这个类型添加用例.
     */
    public static void useCase(int N) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < N; i++) {
            double n = Math.random();
            System.out.println(n);
            if (n < 0.46) heads.increment();
            else tails.increment();
        }
        System.out.println(heads.toString());
        System.out.println(tails.toString());
    }
}

public class Tests {
    public static void main(String[] args) {
        // 在这里声明了一个 `Counter` 类型的变量名为 `counter`, 这个变量是放在`栈`里面的.
        // 这种在函数内声明的变量叫做局部变量.
        Counter counter;
        counter = new Counter("ctr1"); // 这里调用了 `Counter` 的构造方法, 创建了一个对象放在`堆`中, 然后返回它的内存地址(也就是`标识`)赋值给变量 `counter`.
        // 现在就有了一个栈中的变量 `counter`, 它的值是一个堆中的内存地址(一个Counter对象的实际位置).
    
        // 下面可以调用 counter 的实例方法(行为), 除了在 Counter 类中实现的 3 个方法之外, 还有其他自动继承的方法.
        // 可以看出抽象数据类型隐藏了值(状态)的细节, 只提供了实例方法来操作值.
        // counter.increment();
        // counter.tally();
        // counter.toString();
        // ...

        // 例子1: 实际应用中, 往往会把一个对象赋值给其他的变量, 在 Java 中被称作`别名`.
        Counter c1 = counter; // 声明了一个 Counter 类型的 `c1` 并把 counter 的值赋值给它. 
        // ***注意: 这里是把 counter 的值, 也就是一个内存地址, 赋值给 c1, 那么 c1 是和 counter 指向了同一个对象(同一个内存地址).
        c1.increment();
        System.out.println(counter.toString());     // 输出: counter ctr1 is 1.
        // 可以看到上面 调用了 c1 的 increment 方法之后, counter 的状态也被改变了(因为它们就是同一个对象).

        // 例子2: 还有一种常见的用法是把一个对象作为参数, 传到另一个方法中使用.
        Counter c2 = new Counter("ctr2");
        Tests.use(c2);
        System.out.println(c2);     // 输出: counter ctr2 is 1.
        // 如同上面的例子, c2 的状态同样被改变了, 所以这个时候传值和 例子1 中是一样的.

        // 总结一下: 数据类型(类) 是一组值(状态) 和一组对值的操作的集合(行为). 对象就是可以储存这种数据类型的实体, 对象三大特性: 状态, 标识, 行为. 面向API编程, 隐藏实现细节.
        /**
         * 关于内存.
         * 当一个程序开始运行的时候系统会创建一个进程(process).
         * 一个进程中默认有一条线程(也就是主线程), 一块`堆(heap)`内存, 堆是这个进程中所有线程共享的.
         * 一个线程被创建的时候, 会为这个线程创建一段`栈(stack)`内存, 栈的大小是固定的(除了有一些语言可以改变, 例如Go).
         * 当程序执行的时候, 一个线程每调用一个函数, 都会在这个线程的栈上加(push)一个`块(block)`, 这个块里就保存了当前函数的参数和局部变量.
         * 随着一个函数的调用结束, 这个块就会被销毁(pop).
         */
    }

    // use a counter
    public static void use(Counter c) {
        c.increment();
    }
}
