package visitor;

/**
 * @author yongjie.zhuang
 */
public class VisitorDemo {

    public static void main(String[] args) {
        Document doc = new Document();
        doc.addElement(new ImgElement());
        doc.addElement(new TextElement());
        doc.addElement(new TextElement());
        doc.addElement(new TextElement());
        doc.addElement(new ImgElement());

        doc.accept(new ConsoleLogElementVisitor());
    }
}
