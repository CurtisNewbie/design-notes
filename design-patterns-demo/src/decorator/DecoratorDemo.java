package decorator;

/**
 * @author yongjie.zhuang
 */
public class DecoratorDemo {

    public static void main(String[] args) {
        Job job = ThreadSafeJobDecorator.decorate(new OneSecondJob());
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                job.run();
            }).start();
        }
    }
}
