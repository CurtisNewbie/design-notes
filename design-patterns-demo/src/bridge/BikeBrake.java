package bridge;

/**
 * @author yongjie.zhuang
 */
public class BikeBrake implements BrakeDevice {

    @Override
    public void brake() {
        System.out.println("Starting bike brake");
    }
}
