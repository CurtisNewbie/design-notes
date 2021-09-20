package state;

/**
 * @author yongjie.zhuang
 */
public class SadState implements State {

    @Override
    public void say() {
        System.out.println("I am sad");
    }
}
