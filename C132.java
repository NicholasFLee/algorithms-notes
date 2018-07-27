import java.util.Iterator;

// je suis toujours heureux de prendre du thé avec toi.
class Node<T> {
    T item;
    Node next;
}

// 1.3.32 Steque 以栈为目标的队列
class Steque<T> {
    private Node<T> first;
    private Node<T> last;

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
        T res = first.item;
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


// 1.3.33 Deque
// 双向链表实现
class Deque<T> implements Iterable {

    private Node<T> first;
    private Node<T> last;
    private int N = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void pushLeft(T item) {
        Node<T> newFirst = new Node<>();
        newFirst.item = item;
        newFirst.next = first;
        if (first == null) {
            last = newFirst;
        }
        first = newFirst;
        N++;
    }

    public void pushRight(T item) {
        Node<T> newLast = new Node<>();
        newLast.item = item;
        if (last == null) {
            first = newLast;
        } else {
            last.next = newLast;
        }
        last = newLast;
        N++;
    }

    public T popLeft() {
        T res = (T) first.item;
        if (first == last) {
            first = null;
            last = null;
        }
        first = first.next;
        N--;
        return res;
    }

    public T popRight() {
        T res = (T) last.item;
        if (first == last) {
            first = null;
            last = null;
        }
        // find `second last` then delete its `next`
        Node<T> secondLast = first;
        while (secondLast.next != last) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        N--;
        return res;
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private Node<T> first;
        
        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {
            T res = first.item;
            first = first.next;
            return res;
        }
    }

    @Override
    public String toString() {
        String res = description(first, "");
        res += ("\nsize is: " + size());
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
        // stequeTest();
        dequeTest();
    }

    public static void stequeTest() {
        Steque<String> steque = new Steque<>();
        steque.push("1");
        steque.enqueue("3");
        steque.push("2");
        steque.enqueue("4");
        steque.pop();
        System.out.println(steque.toString());
    }

    public static void dequeTest() {
        Deque<String> deque = new Deque<>();
        deque.pushLeft("l");
        deque.pushLeft("ll");
        deque.pushLeft("lll");
        deque.popRight();
        deque.popLeft();
        System.out.println(deque);
    }
}