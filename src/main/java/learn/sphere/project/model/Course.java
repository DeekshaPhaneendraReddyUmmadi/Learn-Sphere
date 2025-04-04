package learn.sphere.project.model;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    
    @Id
    private Long courseId;

    private String courseName;
    
    private Double coursePrice;
}