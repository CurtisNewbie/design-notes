package factorymethod;

/**
 * @author yongjie.zhuang
 */
public enum TomType {

    TALLER_TOM(new TallerTomProvider()),
    SHORTER_TOM(new ShorterTomProvider());

    private final TomProvider provider;

    TomType(TomProvider provider) {
        this.provider = provider;
    }

    public TomProvider getProvider() {
        return provider;
    }
}
