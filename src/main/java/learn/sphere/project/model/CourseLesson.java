package learn.sphere.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_lessons")
@Data
@NoArgsConstructor
public class CourseLesson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long courseId;
    
    private Long lessonId;

    public CourseLesson(Long courseId, Long lessonId) {
        this.courseId = courseId;
        this.lessonId = lessonId;
    }
}














// @Entity
// @Table(name = "course_lessons")
// @Data
// @NoArgsConstructor
// public class CourseLesson {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private Long id;
    
//     @ManyToOne
//     @JoinColumn(name = "course_id", nullable = false)
//     private Course course;
    
//     @ManyToOne
//     @JoinColumn(name = "lesson_id", nullable = false)
//     private Lesson lesson;

//     public CourseLesson(Course course, Lesson lesson) {
//         this.course = course;
//         this.lesson = lesson;
//     }
// }