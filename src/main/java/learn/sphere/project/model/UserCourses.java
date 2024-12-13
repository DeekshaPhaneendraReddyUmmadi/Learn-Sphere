package learn.sphere.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long userId;

    private Long courseId;

    public UserCourses(Long userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }
}
