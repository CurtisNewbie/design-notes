package proxy;

/**
 * @author yongjie.zhuang
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Service target = new ServiceImpl();
        Service proxy = ProxyUtil.proxy(target, new ServiceLogProxy(target));
        proxy.doThings();
    }
}
