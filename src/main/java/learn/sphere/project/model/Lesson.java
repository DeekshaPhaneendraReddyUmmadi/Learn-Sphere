package learn.sphere.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    
    private List<String> lessonName;
    private String lessonLink;
    private String lessonTopics;
}
