package bridge;

/**
 * @author yongjie.zhuang
 */
public class BridgeDemo {

    public static void main(String[] args) {
        AbstractVehicle car = new Car(new CarBrake());
        car.brake();
        AbstractVehicle motorBike = new MotorBike(new BikeBrake());
        motorBike.brake();
    }
}
