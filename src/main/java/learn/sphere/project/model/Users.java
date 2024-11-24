package learn.sphere.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
// import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
// @Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty(message = "Name missing")
    private String name;

    @Email(message = "Invalid email")
    @NotEmpty(message = "Email missing")
    private String email;

    @NotEmpty(message = "Password missing")
    private String password;

    private String role;

    // public Users(){

    // }

    public Users(final String name, final String email, final String password, final String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
