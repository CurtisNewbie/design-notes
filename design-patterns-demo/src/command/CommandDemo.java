package command;

/**
 * @author yongjie.zhuang
 */
public class CommandDemo {

    public static void main(String[] args) {
        ImageComponent component = new ImageComponent();
        component.setOnClick(new EchoCommand("ImageComponent clicked"));
        component.setOnFocus(new EchoCommand("ImageComponent focused"));
        component.click();
        component.focus();
    }
}
