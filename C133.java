import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


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
        N++;
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
            shuffleArray(randomArray);
        }

        private void shuffleArray(T[] ar) {
            // If running on Java 6 or older, use `new Random()` on RHS here
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                T a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
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
        RandomBag<Integer> rb = new RandomBag<>();
        for (int i = 0; i < 10; i++) {
            rb.add(i);
        }
        Iterator i = rb.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
