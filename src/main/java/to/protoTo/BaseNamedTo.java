package to.protoTo;

public abstract class BaseNamedTo extends BaseTo {
    protected String name;

    public BaseNamedTo(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public BaseNamedTo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
