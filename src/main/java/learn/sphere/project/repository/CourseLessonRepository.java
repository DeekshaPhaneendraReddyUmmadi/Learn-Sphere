
package learn.sphere.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sphere.project.model.CourseLesson;

@Repository
public interface CourseLessonRepository extends JpaRepository<CourseLesson, Long>{
    
}
