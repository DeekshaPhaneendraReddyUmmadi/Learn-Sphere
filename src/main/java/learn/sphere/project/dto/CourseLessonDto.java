package learn.sphere.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseLessonDto {
    private Long courseId;
    private String courseName;
    private Double coursePrice;
    private List<String> lessonNames;
    // private String lessonNames;
}
