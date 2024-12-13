package learn.sphere.project.util.constant;

public enum Role {
    USER ("ROLE_USER"), ADMIN ( "ROLE_ADMIN"), STUDENT ("ROLE_STUDENT"), TRAINER("ROLE_TRAINER");
    private String role;
    private Role(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}