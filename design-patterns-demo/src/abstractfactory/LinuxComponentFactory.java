package abstractfactory;

/**
 * @author yongjie.zhuang
 */
public class LinuxComponentFactory implements ComponentFactory {

    @Override
    public Button getButton(ButtonType t) {
        return new LinuxButton();
    }

    @Override
    public Icon getIcon(IconType t) {
        return new LinuxIcon();
    }

    private static class LinuxButton implements Button {

        @Override
        public String describe() {
            return "Button that only works on Linux";
        }
    }

    private static class LinuxIcon implements Icon {

        @Override
        public String describe() {
            return "Icon that only works on Linux";
        }
    }
}
