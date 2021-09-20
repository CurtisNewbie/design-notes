package bridge;

/**
 * @author yongjie.zhuang
 */
public abstract class AbstractVehicle {

    protected final BrakeDevice brakeDevice;

    public AbstractVehicle(BrakeDevice brake) {
        this.brakeDevice = brake;
    }

    abstract void brake();
}
