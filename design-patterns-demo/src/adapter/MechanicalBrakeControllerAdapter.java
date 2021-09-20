package adapter;

/**
 * @author yongjie.zhuang
 */
public class MechanicalBrakeControllerAdapter implements BrakeAdapter {

    @Override
    public void brake(BrakeController controller) {
        ((MechanicalBrakeController) controller).stepOnBrake();
    }

    @Override
    public boolean support(Class<? extends BrakeController> brakeController) {
        return MechanicalBrakeController.class.isAssignableFrom(brakeController);
    }
}
