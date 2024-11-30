
package learn.sphere.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learn.sphere.project.dto.CourseLessonDto;
import learn.sphere.project.model.CourseLesson;

// @Repository
// public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long>{
//     @Query("SELECT new learn.sphere.project.dto.CourseLessonDto(c.courseId, c.courseName, c.coursePrice, l.lessonName) " +
//             "FROM Course c JOIN CourseLesson cl ON c.courseId = cl.courseId " +
//             "JOIN Lesson l ON cl.lessonId = l.lessonId")
//     List<CourseLessonDto> findAllCoursesWithLessons();
// }


@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long> {
    @Query("SELECT new learn.sphere.project.dto.CourseLessonDto(c.courseId, c.courseName, c.coursePrice, l.lessonName) " +
            "FROM Course c JOIN CourseLesson cl ON c.courseId = cl.courseId " +
            "JOIN Lesson l ON cl.lessonId = l.lessonId")
    List<CourseLessonDto> findAllCoursesWithLessons();

    // @Query("SELECT new learn.sphere.project.dto.CourseLessonDto(c.courseId, c.courseName, c.coursePrice, LISTAGG(l.lessonName, ', ') WITHIN GROUP (ORDER BY l.lessonName)) " +
    //     "FROM Course c JOIN CourseLesson cl ON c.courseId = cl.courseId " +
    //     "JOIN Lesson l ON cl.lessonId = l.lessonId " +
    //     "GROUP BY c.courseId, c.courseName, c.coursePrice")
    // List<CourseLessonDto> findAllCoursesWithLessons();

}
