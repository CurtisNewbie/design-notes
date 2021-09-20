package singleton;

/**
 * @author yongjie.zhuang
 */
public final class NonEnumEagerSingleton {

    public static final NonEnumEagerSingleton INSTANCE = new NonEnumEagerSingleton();

    private NonEnumEagerSingleton() {

    }

}
