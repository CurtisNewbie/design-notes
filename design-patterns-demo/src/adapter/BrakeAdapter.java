package adapter;

/**
 * @author yongjie.zhuang
 */
public interface BrakeAdapter {

    void brake(BrakeController controller);

    boolean support(Class<? extends BrakeController> brakeController);
}
