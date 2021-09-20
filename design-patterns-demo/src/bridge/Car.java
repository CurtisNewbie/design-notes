package bridge;

/**
 * @author yongjie.zhuang
 */
public class Car extends AbstractVehicle {

    public Car(BrakeDevice accelerator) {
        super(accelerator);
    }

    @Override
    void brake() {
        brakeDevice.brake();
        activateAbsIfNecessary();
    }

    private void activateAbsIfNecessary() {
        System.out.println("Activate ABS if necessary for car");
    }
}
