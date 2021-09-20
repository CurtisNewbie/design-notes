package iterator;

/**
 * @author yongjie.zhuang
 */
public interface CollectionIterator<T> {

    T next();

    boolean hasNext();

}
