package model;

public class AbstractNamedEntity extends AbstractEntity {
    private final String name;

    public AbstractNamedEntity(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
