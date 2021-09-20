package builder;

/**
 * @author yongjie.zhuang
 */
public class ShorterDummy implements Dummy {

    private String name;

    public ShorterDummy(String name) {
        this.name = name;
    }

    @Override
    public String getDummyName() {
        return name;
    }

    @Override
    public String doDummyThing() {
        return "Shorter dummy just did dummy thing";
    }
}
