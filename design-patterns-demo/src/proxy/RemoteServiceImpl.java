package proxy;

/**
 * @author yongjie.zhuang
 */
public class RemoteServiceImpl implements RemoteService {

    @Override
    public void invoke() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
