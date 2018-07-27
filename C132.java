class Node<T> {
    T item;
    Node next;
}

// Steque 以栈为目标的队列
class Steque<T> {
    private Node first;
    private Node last;

    // add at the first of the linked list
    public void push(T item) {
        Node<T> newFirst = new Node<>();
        newFirst.item = item;
        newFirst.next = first;
        if (first == null) {
            last = newFirst;
        }
        first = newFirst;
    }

    // pop the first of the list
    public T pop() {
        if (first == null) {
            return null;
        }
        T res = (T) first.item;
        first = first.next;
        return res;
    }

    // add at the last.next
    public void enqueue(T item) {
        Node<T> newLast = new Node<>();
        newLast.item = item;
        last.next = newLast;
        last = newLast;
    }

    @Override
    public String toString() {
        String res = description(first, "");
        return res;
    }

    private String description(Node n, String r) {
        String res = r;
        if (n == null) {
            return res;
        }
        res = res + n.item;
        return description(n.next, res);
    }
}

public class C132 { 
    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("1");
        steque.enqueue("3");
        steque.push("2");
        steque.enqueue("4");
        steque.pop();
        System.out.println(steque.toString());
    }
}