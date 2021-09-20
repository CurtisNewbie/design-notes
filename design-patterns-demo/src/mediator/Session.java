package mediator;

/**
 * @author yongjie.zhuang
 */
public class Session {

    private String name;

    public Session(String name) {
        this.name = name;
    }

    void sendMessage(String msg) {
        System.out.println("Sent message: '" + msg + "' to user: " + name);
    }
}
