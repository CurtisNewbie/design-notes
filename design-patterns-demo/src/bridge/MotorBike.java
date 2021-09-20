package bridge;

/**
 * @author yongjie.zhuang
 */
public class MotorBike extends AbstractVehicle {

    public MotorBike(BrakeDevice accelerator) {
        super(accelerator);
    }

    @Override
    void brake() {
        brakeDevice.brake();
    }
}
