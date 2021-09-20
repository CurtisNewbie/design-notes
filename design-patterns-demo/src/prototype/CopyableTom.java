package prototype;

/**
 * @author yongjie.zhuang
 */
public class CopyableTom implements Copyable {

    private String name;

    public CopyableTom(String name) {
        this.name = name;
    }

    public CopyableTom(CopyableTom t) {
        this.name = t.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object copy() {
        return new CopyableTom(this);
    }

    @Override
    public String toString() {
        return "CopyableTom{" +
                "name='" + name + '\'' +
                '}';
    }
}
