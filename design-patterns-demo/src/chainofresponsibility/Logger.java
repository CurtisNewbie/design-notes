package chainofresponsibility;

/**
 * @author yongjie.zhuang
 */
public interface Logger {

    void log(Message message, LoggerChain loggerChain);
}
