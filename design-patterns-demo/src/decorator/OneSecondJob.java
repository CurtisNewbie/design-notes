package decorator;

/**
 * @author yongjie.zhuang
 */
public class OneSecondJob implements Job {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("One second job done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
