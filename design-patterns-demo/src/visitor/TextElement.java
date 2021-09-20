package visitor;

import java.util.UUID;

/**
 * @author yongjie.zhuang
 */
public class TextElement extends Element {

    @Override
    public String toString() {
        return "A text element " + UUID.randomUUID().toString();
    }
}
