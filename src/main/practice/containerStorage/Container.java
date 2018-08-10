package practice.containerStorage;

import java.util.UUID;

public class Container {
    private String id;
    private String description;

    public Container(String description) {
        this.description = description;
        this.id = UUID.randomUUID().toString();
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }
}
