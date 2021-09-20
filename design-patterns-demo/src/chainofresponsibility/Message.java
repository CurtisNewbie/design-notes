package chainofresponsibility;

/**
 * @author yongjie.zhuang
 */
public class Message {

    private String msg;
    private MessageLevel level;

    public Message(String msg, MessageLevel level) {
        this.msg = msg;
        this.level = level;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MessageLevel getLevel() {
        return level;
    }

    public void setLevel(MessageLevel level) {
        this.level = level;
    }

    enum MessageLevel {
        INFO, DEBUG, ERROR
    }

}
