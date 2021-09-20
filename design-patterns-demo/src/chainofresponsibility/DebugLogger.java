package chainofresponsibility;

/**
 * @author yongjie.zhuang
 */
public class DebugLogger implements Logger {

    @Override
    public void log(Message message, LoggerChain chain) {
        if (Message.MessageLevel.DEBUG == message.getLevel())
            System.out.println("DEBUG - " + message.getMsg());
        chain.doNext(message);
    }
}
