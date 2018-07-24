import java.util.Iterator;

class Stack<T> implements Iterable {
    private class Node {
        T item;
        Node next;
    }
    
    private Node first;
    private int N = 0;

    public void push(T t) {
        Node of = first;
        first = new Node();
        first.item = t;
        first.next = of;
        N++;
    };
    
    public T pop() {
        T res = first.item;
        first = first.next;
        N--;
        return res; 
    }
    
    public boolean isEmpty() { return N == 0; }
    
    public int size() { return N; }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node n = first;

        @Override
        public boolean hasNext() {
            return n != null;
        }

        @Override
        public T next() {
            T res = n.item;
            n = n.next;
            return res;
        }
    }
}

public class C131 {
    public static void main(String[] args) {
        // stackTest();
        parentheses("{[()]()}");
        parentheses("[(])");
    }

    public static void stackTest() {
        Stack<String> stack = new Stack<String>();
        stack.push("un");
        stack.push("deux");
        stack.push("trois");

        Iterator itr = stack.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static boolean isPair(String a, String b) {
        if (a.equals("(") && b.equals(")") ||
            a.equals("[") && b.equals("]") ||
            a.equals("{") && b.equals("}")) {
                return true;
        }
        return false;
    }
    // 练习 1.3.4
    public static boolean parentheses(String ps) {
        Stack<String> left = new Stack<String>();
        for (char c : ps.toCharArray()) {
            String s = Character.toString(c);
            if (s.equals("{") || s.equals("[") || s.equals("(")) {
                left.push(s);
            } else {
                if (!isPair(left.pop(), s)) {
                    System.out.println("false");
                    return false;
                }
            }
        }
        System.out.println("true");
        return true;
    }
}
