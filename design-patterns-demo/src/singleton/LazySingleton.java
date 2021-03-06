package singleton;

/**
 * @author yongjie.zhuang
 */
public final class LazySingleton {

    private static LazySingleton instance = null;

    private LazySingleton(){

    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }

}
