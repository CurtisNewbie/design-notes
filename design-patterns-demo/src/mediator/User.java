package mediator;

/**
 * @author yongjie.zhuang
 */
public class User {

    private String name;

    private Session session;

    public User(String name) {
        this.name = name;
        this.session = new Session(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
