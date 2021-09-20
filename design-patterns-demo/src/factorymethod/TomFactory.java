package factorymethod;

/**
 * @author yongjie.zhuang
 */
public abstract class TomFactory {

    private static final TomFactory tomFactory = new ConcreteTomFactory();

    public abstract Tom getTom(TomType type);

    public static TomFactory getSingleton() {
        return tomFactory;
    }

    private static class ConcreteTomFactory extends TomFactory {

        @Override
        public Tom getTom(TomType type) {
            return type.getProvider().provide();
        }
    }
}
