package visitor;

import java.util.UUID;

/**
 * @author yongjie.zhuang
 */
public class ImgElement extends Element {

    @Override
    public String toString() {
        return "An image element " + UUID.randomUUID().toString();
    }
}
