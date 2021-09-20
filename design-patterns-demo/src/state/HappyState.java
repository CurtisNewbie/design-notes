package state;

/**
 * @author yongjie.zhuang
 */
public class HappyState implements State {

    @Override
    public void say() {
        System.out.println("I am happy");
    }
}
