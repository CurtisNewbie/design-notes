package builder;

import java.util.Objects;

/**
 * @author yongjie.zhuang
 */
public class DummyBuilder {
    private String name;
    private DummyType dummyType;

    public DummyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DummyBuilder setDummyType(DummyType type) {
        this.dummyType = type;
        return this;
    }

    public Dummy build() {
        Objects.requireNonNull(name);
        Objects.requireNonNull(dummyType);
        if (dummyType == DummyType.SHORTER)
            return new ShorterDummy(name);
        else
            return new TallerDummy(name);
    }

    enum DummyType {
        SHORTER,
        TALLER;
    }
}
