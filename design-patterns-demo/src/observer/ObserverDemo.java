package observer;

/**
 * @author yongjie.zhuang
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Subject<String> subject = new Subject<>();
        subject.attach((v) -> {
            System.out.println("Observed new value " + String.valueOf(v));
        });
        subject.setT("Yoyoyo");
        subject.setT("Lemon tree");
        subject.setT(null);
    }
}
