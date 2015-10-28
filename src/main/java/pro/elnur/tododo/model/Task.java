package pro.elnur.tododo.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

@Entity
public class Task {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID id;
    private String text;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
