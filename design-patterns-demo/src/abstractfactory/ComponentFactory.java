package abstractfactory;

/**
 * @author yongjie.zhuang
 */
public interface ComponentFactory {

    Button getButton(ButtonType t);

    Icon getIcon(IconType t);

}
