package adapter;

/**
 * @author yongjie.zhuang
 */
public class AdapterDemo {

    public static void main(String[] args) {
        Car electricalCar = new Car(new ElectricalBrakeController());
        electricalCar.brake();
        Car mechanicCar = new Car(new MechanicalBrakeController());
        mechanicCar.brake();
    }

}
