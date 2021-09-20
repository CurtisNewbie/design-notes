package chainofresponsibility;

/**
 * @author yongjie.zhuang
 */
public class InfoLogger implements Logger {

    @Override
    public void log(Message message, LoggerChain chain) {
        if (Message.MessageLevel.INFO == message.getLevel())
            System.out.println("INFO - " + message.getMsg());
        chain.doNext(message);
    }
}
