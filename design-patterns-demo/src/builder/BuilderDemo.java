package builder;

/**
 * @author yongjie.zhuang
 */
public class BuilderDemo {

    public static void main(String[] args) {
        Dummy tallerDummy = new DummyBuilder()
                .setName("taller dummy")
                .setDummyType(DummyBuilder.DummyType.TALLER)
                .build();

        System.out.println(tallerDummy.getDummyName());
        System.out.println(tallerDummy.doDummyThing());

        Dummy shorterDummy = new DummyBuilder()
                .setName("shorter dummy")
                .setDummyType(DummyBuilder.DummyType.SHORTER)
                .build();

        System.out.println(shorterDummy.getDummyName());
        System.out.println(shorterDummy.doDummyThing());
    }
}
