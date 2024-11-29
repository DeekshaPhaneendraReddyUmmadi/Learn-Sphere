package learn.sphere.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.sphere.project.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
}
