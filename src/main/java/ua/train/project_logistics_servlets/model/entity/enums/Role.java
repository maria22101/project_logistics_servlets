package ua.train.project_logistics_servlets.model.entity.enums;

public enum Role {
    USER("USER"), ADMIN("ADMIN"), UNKNOWN("UNKNOWN");

    private final String description;

    private Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}