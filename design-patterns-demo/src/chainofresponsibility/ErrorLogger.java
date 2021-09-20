package chainofresponsibility;

/**
 * @author yongjie.zhuang
 */
public class ErrorLogger implements Logger {

    @Override
    public void log(Message message, LoggerChain chain) {
        if (Message.MessageLevel.ERROR == message.getLevel())
            System.out.println("ERROR - " + message.getMsg());
        chain.doNext(message);
    }
}
