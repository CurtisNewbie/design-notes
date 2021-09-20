package mediator;

/**
 * @author yongjie.zhuang
 */
public class MediatorDemo {

    public static void main(String[] args) {
        Room room = new Room();
        room.addUser(new User("sharon"));
        room.addUser(new User("yongj"));
        room.broadcast("Hi guys");
        room.sendTo("sharon", "Hi sharon");
        room.sendTo("yongj", "Hi yongj");
    }
}
