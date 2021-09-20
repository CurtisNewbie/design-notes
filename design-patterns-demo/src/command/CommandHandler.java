package command;

/**
 * @author yongjie.zhuang
 */
public interface CommandHandler {

    void handle(Command command);

    boolean supports(Class<? extends Command> clz);
}
