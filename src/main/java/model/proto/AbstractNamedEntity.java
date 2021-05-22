package model.proto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractNamedEntity extends AbstractEntity {
    @NotBlank
    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 30)
    protected String name;

    protected AbstractNamedEntity(int id, String name) {
        super(id);
        this.name = name;
    }

    protected AbstractNamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name)    {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + name + ')';
    }
}
