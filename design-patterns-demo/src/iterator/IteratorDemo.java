package iterator;

/**
 * @author yongjie.zhuang
 */
public class IteratorDemo {

    public static void main(String[] args) {
        Bucket<String> bucket = new Bucket<>(10);
        bucket.put("yongj");
        bucket.put("sharon");
        bucket.put("banana");
        CollectionIterator<String> iterator = bucket.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
