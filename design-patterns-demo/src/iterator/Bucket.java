package iterator;

/**
 * @author yongjie.zhuang
 */
public class Bucket<T> implements IterableCollection {

    private int curr = 0;
    private Object[] arr;

    public Bucket(int capacity) {
        arr = new Object[capacity];
    }

    public void put(T t) {
        if (curr == arr.length)
            throw new IllegalStateException("Buck is full");
        arr[curr++] = t;
    }


    @Override
    public CollectionIterator getIterator() {
        return new BucketIterator();
    }

    private class BucketIterator implements CollectionIterator<T> {

        private int ptr = 0;

        @Override
        public T next() {
            return (T) arr[ptr++];
        }

        @Override
        public boolean hasNext() {
            return ptr < Bucket.this.curr;
        }
    }
}
