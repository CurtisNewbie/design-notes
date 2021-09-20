package observer;

/**
 * @author yongjie.zhuang
 */
public interface Observer<T> {

    void notifyChange(T t);
}
