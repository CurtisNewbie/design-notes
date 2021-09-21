package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yongjie.zhuang
 */
public class RemoteServiceSerialInvocationProxy implements InvocationHandler {

    private ConcurrentMap<Method, AtomicInteger> throttleMap = new ConcurrentHashMap<>();

    private final RemoteService target;

    public RemoteServiceSerialInvocationProxy(RemoteService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();

        Object o;
        try {
            while (shouldThrottle(method))
                ;
            o = method.invoke(target, args);
        } finally {
            stopThrottling(method);
        }

        long endTime = System.nanoTime();
        System.out.println("Invoked method " + method.getName() + " args: " + Arrays.toString(args) + ", took " +
                ((endTime - startTime) / 1000_000) + " milliseconds");
        return o;
    }

    private boolean shouldThrottle(Method method) {
        throttleMap.computeIfAbsent(method, (k) -> new AtomicInteger(0));
        return !throttleMap.get(method).compareAndSet(0, 1);
    }

    private void stopThrottling(Method method) {
        throttleMap.get(method).compareAndSet(1, 0);
    }
}
