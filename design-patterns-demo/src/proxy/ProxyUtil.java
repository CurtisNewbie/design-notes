package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author yongjie.zhuang
 */
public final class ProxyUtil {

    private ProxyUtil() {
    }

    public static <T> T proxy(T target, InvocationHandler proxy) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(cl, target.getClass().getInterfaces(), proxy);
    }
}
