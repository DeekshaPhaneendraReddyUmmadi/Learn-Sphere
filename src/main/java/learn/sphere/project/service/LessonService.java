package learn.sphere.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.CourseLesson;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.repository.LessonRepository;

@Service
public class LessonService {
    
    @Autowired
    private LessonRepository lessonRepository;
   
    @Autowired
    private CourseLessonService courseLessonService;

    public Lesson saveLesson(Lesson lesson){
        CourseLesson cL = new CourseLesson();
        cL.setCourseId(lesson.getCourseId());
        cL.setLessonId(lesson.getLessonId());
        courseLessonService.updateCourseLesson(cL);
        return lessonRepository.save(lesson);
    }

    public Optional<Lesson> findAll(Long lessonid){
        return lessonRepository.findByLessonId(lessonid);
    }
}
