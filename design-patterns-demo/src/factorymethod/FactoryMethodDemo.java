package factorymethod;

/**
 * @author yongjie.zhuang
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        TomFactory tomFactory = TomFactory.getSingleton();
        System.out.println(tomFactory.getTom(TomType.SHORTER_TOM).selfIntro());
        System.out.println(tomFactory.getTom(TomType.TALLER_TOM).selfIntro());
    }
}
