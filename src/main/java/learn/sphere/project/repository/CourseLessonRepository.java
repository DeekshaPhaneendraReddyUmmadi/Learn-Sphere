package learn.sphere.project.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learn.sphere.project.dto.CourseLessonDto;
import learn.sphere.project.model.CourseLesson;



@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long> {
    @Query(value = "SELECT c.course_id, c.course_name, c.course_price, GROUP_CONCAT(DISTINCT l.lesson_name) AS lesson_names " +
                "FROM courses c " +
                "JOIN course_lessons cl ON c.course_id = cl.course_id " +
                "JOIN lessons l ON cl.lesson_id = l.lesson_id " +
                "GROUP BY c.course_id", 
        nativeQuery = true)
    List<Object[]> findAllCoursesWithLessonsRaw();

    default List<CourseLessonDto> findAllCoursesWithLessons() {
        List<Object[]> results = findAllCoursesWithLessonsRaw();
        List<CourseLessonDto> dtos = new ArrayList<>();
        for (Object[] result : results) {
            Long courseId = ((Number) result[0]).longValue();
            String courseName = (String) result[1];
            Double coursePrice = ((Number) result[2]).doubleValue();
            String lessonNames = (String) result[3];
            dtos.add(new CourseLessonDto(courseId, courseName, coursePrice, lessonNames));
        }
        return dtos;
    }
}