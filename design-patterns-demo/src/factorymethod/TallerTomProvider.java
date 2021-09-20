package factorymethod;

/**
 * @author yongjie.zhuang
 */
public class TallerTomProvider implements TomProvider {

    @Override
    public Tom provide() {
        return new TallerTom();
    }

    private static class TallerTom implements Tom {

        @Override
        public String selfIntro() {
            return "I can see things that they can't see, lul";
        }
    }
}
