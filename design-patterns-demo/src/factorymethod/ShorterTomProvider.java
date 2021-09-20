package factorymethod;

/**
 * @author yongjie.zhuang
 */
public class ShorterTomProvider implements TomProvider {

    @Override
    public Tom provide() {
        return new ShorterTom();
    }

    private static class ShorterTom implements Tom {

        @Override
        public String selfIntro() {
            return "Shit, I am so short";
        }
    }
}
