package learn.sphere.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "lessons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    
    @Id
    private Long lessonId;
    
    private Long courseId;
    
    private String lessonName;
    
    private String lessonLink;
    
    private String lessonTopics;
    
    private String comments;
}