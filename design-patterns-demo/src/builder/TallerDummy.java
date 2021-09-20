package builder;

/**
 * @author yongjie.zhuang
 */
public class TallerDummy implements Dummy {

    private String name;

    public TallerDummy(String name) {
        this.name = name;
    }

    @Override
    public String getDummyName() {
        return name;
    }

    @Override
    public String doDummyThing() {
        return "Taller dummy just did dummy thing";
    }
}
