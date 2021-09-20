package bridge;

/**
 * @author yongjie.zhuang
 */
public class CarBrake implements BrakeDevice {

    @Override
    public void brake() {
        System.out.println("Starting car brake");
    }
}
