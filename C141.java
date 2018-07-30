// 1.4.27
class Staqueue<T> {
    private Stack<T> s1;
    private Stack<T> s2;
    
    public Staqueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(T t) {
        s1.push(t);
    }

    public T dequeue() {
        if (s1.isEmpty()) return null;
        if (s2.isEmpty())
            while (!s1.isEmpty()) 
                s2.push(s1.pop());
        return s2.pop();
    }
}

public class C141 {
    public static void main(String[] args) {
        Staqueue<Integer> staq = new Staqueue<>();
        staq.enqueue(1);
        staq.enqueue(2);
        staq.dequeue();
        staq.enqueue(4);
        staq.dequeue();
        System.out.println(staq.dequeue() == 4);
    }
}