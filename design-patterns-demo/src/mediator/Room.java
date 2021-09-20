package mediator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yongjie.zhuang
 */
public class Room {

    private Map<String, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getName(), user);
    }

    public void broadcast(String msg) {
        for (User u : userMap.values()) {
            u.getSession().sendMessage(msg);
        }
    }

    public void sendTo(String name, String msg) {
        User user = userMap.get(name);
        if (user != null) {
            user.getSession().sendMessage(msg);
        }
    }
}
