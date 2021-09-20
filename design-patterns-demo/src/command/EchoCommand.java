package command;

/**
 * @author yongjie.zhuang
 */
public class EchoCommand implements Command {
    private String msg;

    public EchoCommand(String msg) {
        this.msg = msg;
    }

    @Override
    public void doExecute() {
        System.out.println("Echo " + msg);
    }
}
