package adapter;

import java.util.Arrays;
import java.util.List;

/**
 * @author yongjie.zhuang
 */
public class Car {

    private BrakeController brakeController;
    private List<BrakeAdapter> brakeAdapters = Arrays.asList(
            new ElectricalBrakeControllerAdapter(),
            new MechanicalBrakeControllerAdapter()
    );

    public Car(BrakeController brakeController) {
        this.brakeController = brakeController;
    }

    public void brake() {
        for (BrakeAdapter adapter : brakeAdapters)
            if (adapter.support(brakeController.getClass()))
                adapter.brake(brakeController);
    }

}
