import java.util.Iterator;

class Stack<T> implements Iterable {

    // public static Stack<String> copy(Stack<String> s) {
    //     Iterator i = s.iterator();
    //     Stack<String> copied = new Stack<String>();
    //     copied.N = s.N;
    //     Stack<String>.Node first = new Stack<String>.Node();
    //     while (i.hasNext()) {
    //         Stack<String>.Node n = new Stack<String>.Node();
    //         Stack<String>.Node on = i.next();
    //         n.item = on.item;
    //         first.item = n;
    //     }
    // }

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
    
    // 练习 1.3.7
    public T peek() {
        return first.item;
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
        // parentheses("{[()]()}");
        // parentheses("[(])");
        fillUpInfixExpression("1+2)*3-4)*5-6)))");
        evaluatePostfix(infixToPostfix("((1+2)*((3-4)*(5-6)))"));
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

    // 练习 1.3.9
    // 用两个栈, 一个放`数字`, 一个放`运算符`, 遇到`右括号`就 pop 两个`数字栈`和一个`运算符栈`运算完放入`数字栈`
    // 运算: 数字前后加括号
    public static String fillUpInfixExpression(String ie) {
        Stack<String> digits = new Stack<>();
        Stack<String> operators = new Stack<>();
        String res = "";
        for (char c : ie.toCharArray()) {
            String s = Character.toString(c);
            if (isOperator(s)) operators.push(s);
            else if (s.equals(")")) {
                String second = digits.pop();
                String first = digits.pop();
                String operator = operators.pop();
                res = "(" + first + operator + second + ")";
                digits.push(res);
            } else {
                digits.push(s);
            }
        }
        System.out.println(res);
        return res;
    }
    public static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    // 练习 1.3.10
    public static String infixToPostfix(String in) {
        Stack<String> digits = new Stack<>();
        Stack<String> operators = new Stack<>();
        String res = "";
        for (char c : in.toCharArray()) {
            String s = Character.toString(c);
            if (isOperator(s)) operators.push(s);
            else if (Character.isDigit(c)) digits.push(s);
            else if (s.equals(")")) {
                String second = digits.pop();
                String first = digits.pop();
                String operator = operators.pop();
                res = first + second + operator;
                digits.push(res);
            }
        }
        System.out.println(res);
        return res;
    }

    // 练习 1.3.11
    public static int evaluatePostfix(String in) {
        Stack<String> digits = new Stack<>();
        int res = 0;
        for (char c : in.toCharArray()) {
            String s = Character.toString(c);
            if (!isOperator(s)) digits.push(s);
            else {
                String second = digits.pop();
                String first = digits.pop();
                res = calculate(first, second, s);
                digits.push(Integer.toString(res));
            }
        }
        System.out.println(res);
        return res;
    }
    public static int calculate(String a, String b, String op) {
        int i = Integer.parseInt(a);
        int j = Integer.parseInt(b);
        switch (op) {
            case "+":
                return i + j;
            case "-":
                return i - j;
            case "*":
                return i * j;
            case "/":
                return i / j;
        }
        return 0;
    }

}
