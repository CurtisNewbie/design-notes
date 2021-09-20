package chainofresponsibility;

import java.util.Arrays;
import java.util.List;

/**
 * @author yongjie.zhuang
 */
public class LoggerChain {

    private int next = 0;
    private List<Logger> logger = Arrays.asList(new InfoLogger(), new ErrorLogger(), new DebugLogger());

    void doNext(Message message) {
        if (next < logger.size())
            logger.get(next++).log(message, this);
    }

}
