package learn.sphere.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sphere.project.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
