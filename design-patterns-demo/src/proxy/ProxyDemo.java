package proxy;

/**
 * @author yongjie.zhuang
 */
public class ProxyDemo {

    public static void main(String[] args) {
        final RemoteService target = new RemoteServiceImpl();
        final RemoteService serialInvocationProxy = ProxyUtil.proxy(target, new RemoteServiceSerialInvocationProxy(target));
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                serialInvocationProxy.invoke();
            }).start();
        }
    }
}
