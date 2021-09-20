package visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yongjie.zhuang
 */
public class Document {

    private List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return elements;
    }

    public void addElement(Element ele) {
        this.elements.add(ele);
    }

    void accept(ElementVisitor visitor) {
        for (Element e : elements) {
            visitor.visit(e);
        }
    }
}
