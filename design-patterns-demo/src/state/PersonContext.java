package state;

/**
 * @author yongjie.zhuang
 */
public class PersonContext {

    private State state = new NormalState();

    void say() {
        state.say();
    }

    void setState(State state) {
        this.state = state;
    }
}
