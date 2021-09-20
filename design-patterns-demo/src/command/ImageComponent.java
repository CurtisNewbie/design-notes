package command;


/**
 * @author yongjie.zhuang
 */
public class ImageComponent {

    private Command onClick;
    private Command onFocus;

    public void setOnClick(Command command) {
        this.onClick = command;
    }

    public void setOnFocus(Command command) {
        this.onFocus = command;
    }

    public void click() {
        if (onClick != null)
            onClick.doExecute();
    }

    public void focus() {
        if (onFocus != null)
            onFocus.doExecute();
    }

}
