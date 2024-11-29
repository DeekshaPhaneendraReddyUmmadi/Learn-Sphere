package learn.sphere.project.model;

import jakarta.persistence.*;
// import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "course_lessons")
@Data
@NoArgsConstructor

public class CourseLesson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long courseId;

    private Long lessonId;

    public CourseLesson(Long courseId, Long lessonId){
        this.courseId = courseId;
        this.lessonId = lessonId;
    }
}
