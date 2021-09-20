package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yongjie.zhuang
 */
public class ServiceLogProxy implements InvocationHandler {

    private final Service target;

    public ServiceLogProxy(Service target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        System.out.println("Invoking method " + method.getName() + " args: " + Arrays.toString(args));

        Object o = method.invoke(target, args);

        long endTime = System.nanoTime();
        System.out.println("Invoked method " + method.getName() + " args: " + Arrays.toString(args) + ", took " +
                ((endTime - startTime) / 1000_000) + " milliseconds");
        return o;
    }
}
