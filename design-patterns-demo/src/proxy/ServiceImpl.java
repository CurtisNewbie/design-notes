package proxy;

/**
 * @author yongjie.zhuang
 */
public class ServiceImpl implements Service {

    @Override
    public void doThings() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
