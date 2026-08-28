package com.example.acl;

public class ModernCustomerDto {
    private String id;
    private String fullName;
    private String email;
    private boolean active;

    public ModernCustomerDto(String id, String fullName, String email, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public boolean isActive() { return active; }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"fullName\":\"" + fullName +
               "\",\"email\":\"" + email + "\",\"active\":" + active + "}";
    }
}
