package state;

/**
 * @author yongjie.zhuang
 */
public class NormalState implements State {

    @Override
    public void say() {
        System.out.println("I am normal");
    }
}
