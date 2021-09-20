package abstractfactory;

import java.util.Map;

/**
 * @author yongjie.zhuang
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        ComponentFactory factory;
        String os = System.getProperty("os.name");
        System.out.println("Your os: " + os);
        // this demo only supports linux and windows
        if (os.toLowerCase().contains("linux")) {
            factory = new LinuxComponentFactory();
        } else {
            factory = new WindowsComponentFactory();
        }

        System.out.println(factory.getButton(ButtonType.BIG).describe());
        System.out.println(factory.getIcon(IconType.ROUNDED).describe());
    }
}
