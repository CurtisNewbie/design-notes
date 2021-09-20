package visitor;

/**
 * @author yongjie.zhuang
 */
public class ConsoleLogElementVisitor implements ElementVisitor {

    @Override
    public void visit(Element element) {
        System.out.println(element.toString());
    }
}
