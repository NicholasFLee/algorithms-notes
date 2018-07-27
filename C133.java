import java.util.Iterator;

class RandomBag<T> implements Iterable {

    private int cap = 10;
    private T[] array = (T[]) new Object[cap];
    private int N = 0;

    public boolean isEmpty() { return N == 0; }

    public int size() { return N; }

    public void add(T t) {
        if (N == array.length) {
            cap *= 2;
            T[] newArray = (T[]) new Object[cap];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
        }
        array[N] = t;
    }

    @Override
    public Iterator iterator() {
        return new RandomBagIterator();
    }

    class RandomBagIterator implements Iterator<T> {

        private T[] randomArray = (T[]) new Object[N];
        private int i = 0;

        public RandomBagIterator() {
            for (int i = 0; i < N; i++) {
                randomArray[i] = array[i];
            }
            if (Math.random() > Math.random()) {

            }
        }

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public T next() {
            return randomArray[i++];
        }
    }

}

public class C133 {
    public static void main(String[] args) {
        
    }
}
