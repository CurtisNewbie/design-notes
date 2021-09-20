package state;

/**
 * @author yongjie.zhuang
 */
public class StateDemo {

    public static void main(String[] args) {
        State happy = new HappyState();
        State sad = new SadState();
        State normal = new NormalState();

        PersonContext person = new PersonContext();
        person.say();
        person.setState(sad);
        person.say();
        person.setState(happy);
        person.say();
        person.setState(normal);
        person.say();
    }
}
