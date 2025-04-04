package learn.sphere.project.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learn.sphere.project.dto.CoursePurchasedLessonsDto;
import learn.sphere.project.model.UserCourses;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCourses, Long>{
    @Query(value = "SELECT DISTINCT " +
                    "c.course_id, " +
                    "c.course_name, " +
                    "c.course_price, " +
                    "l.lesson_id, " +
                    "l.lesson_name " +
                "FROM courses c " +
                "JOIN course_lessons cl ON c.course_id = cl.course_id " +
                "JOIN lessons l ON cl.lesson_id = l.lesson_id " +
                "JOIN user_courses uc ON c.course_id = uc.course_id " +
                "WHERE uc.user_id = :userId",
            nativeQuery = true)
    List<Object[]> findAllCoursesWithLessonsForUser(Long userId);


    default List<CoursePurchasedLessonsDto> findAllCoursesWithUserAccess(Long userId) {
        List<Object[]> results = findAllCoursesWithLessonsForUser(userId);
        Map<Long, CoursePurchasedLessonsDto> courseMap = new HashMap<>();

        for (Object[] result : results) {
            Long courseId = ((Number) result[0]).longValue();
            String courseName = (String) result[1];
            Double coursePrice = ((Number) result[2]).doubleValue();
            Long lessonId = ((Number) result[3]).longValue();
            String lessonName = (String) result[4];

            if (!courseMap.containsKey(courseId)) {
                List<Long> lessonIds = new ArrayList<>();
                List<String> lessonNames = new ArrayList<>();
                CoursePurchasedLessonsDto dto = new CoursePurchasedLessonsDto(courseId, courseName, coursePrice, lessonIds, lessonNames);
                courseMap.put(courseId, dto);
            }

            CoursePurchasedLessonsDto existingDto = courseMap.get(courseId);
            existingDto.getLessonIds().add(lessonId);
            existingDto.getLessonNames().add(lessonName);
        }
        List<CoursePurchasedLessonsDto> dtos2 = new ArrayList<>(courseMap.values());
        return dtos2;
    }

    
    Optional<UserCourses> findByUserId(Long userid);


    Optional<UserCourses> findByUserIdAndCourseId(Long userId, Long courseId);
    
}