package adapter;

/**
 * @author yongjie.zhuang
 */
public class ElectricalBrakeControllerAdapter implements BrakeAdapter {

    @Override
    public void brake(BrakeController controller) {
        ((ElectricalBrakeController) controller).pushButtonToBrake();
    }

    @Override
    public boolean support(Class<? extends BrakeController> brakeController) {
        return ElectricalBrakeController.class.isAssignableFrom(brakeController);
    }
}
