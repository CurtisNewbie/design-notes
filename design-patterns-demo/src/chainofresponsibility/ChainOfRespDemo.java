package chainofresponsibility;

/**
 * @author yongjie.zhuang
 */
public class ChainOfRespDemo {

    public static void main(String[] args) {
        new LoggerChain().doNext(new Message("I am info message", Message.MessageLevel.INFO));
        new LoggerChain().doNext(new Message("I am debug message", Message.MessageLevel.DEBUG));
        new LoggerChain().doNext(new Message("I am error message", Message.MessageLevel.ERROR));
    }
}
