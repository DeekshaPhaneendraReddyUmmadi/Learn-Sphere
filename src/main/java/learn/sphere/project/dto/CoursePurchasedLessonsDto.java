package learn.sphere.project.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CoursePurchasedLessonsDto {
    private Long courseId;
    private String courseName;
    private Double coursePrice;
    private Long lessonId;
    private String lessonName;

    private List<Long> lessonIds;
    private List<String> lessonNames;

    
    public CoursePurchasedLessonsDto(Long courseId, String courseName, Double coursePrice, Long lessonId,
            String lessonName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.lessonId = lessonId;
        this.lessonName = lessonName;
    }


    public CoursePurchasedLessonsDto(Long courseId, String courseName, Double coursePrice, List<Long> lessonIds,
            List<String> lessonNames) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePrice = coursePrice;
        this.lessonIds = lessonIds;
        this.lessonNames = lessonNames;
    }

    
}
