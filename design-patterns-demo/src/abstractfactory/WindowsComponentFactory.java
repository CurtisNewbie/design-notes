package abstractfactory;

/**
 * @author yongjie.zhuang
 */
public class WindowsComponentFactory implements ComponentFactory {

    @Override
    public Button getButton(ButtonType t) {
        return new WinButton();
    }

    @Override
    public Icon getIcon(IconType t) {
        return new WinIcon();
    }

    private static class WinButton implements Button {

        @Override
        public String describe() {
            return "Button that only works on Windows OS";
        }
    }

    private static class WinIcon implements Icon {

        @Override
        public String describe() {
            return "Icon that only works on Windows OS";
        }
    }
}
