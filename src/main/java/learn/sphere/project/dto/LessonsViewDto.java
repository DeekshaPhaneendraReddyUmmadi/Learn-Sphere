package learn.sphere.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LessonsViewDto {
    private Long lessonId;
    private String lessonName;
    private String lessonTopic;
    private String lessonLink;
    private List<String> cmt;
}
