package prototype;

/**
 * @author yongjie.zhuang
 */
public class CopyTom {

    public static void main(String[] args) {
        Copyable tom = new CopyableTom("somebody");
        Object copy = tom.copy();
        System.out.println("Copy: " + copy);
        System.out.println(tom == copy);
    }

}
