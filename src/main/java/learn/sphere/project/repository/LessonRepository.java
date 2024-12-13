package learn.sphere.project.repository;

import java.util.Optional;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learn.sphere.project.model.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(value = "from Lesson where lessonId = :lessonid")
    Optional<Lesson> findByLessonId(Long lessonid);
    
}