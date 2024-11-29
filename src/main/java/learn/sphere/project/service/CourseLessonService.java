package learn.sphere.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.CourseLesson;
import learn.sphere.project.repository.CourseLessonRepository;

@Service
public class CourseLessonService {


    @Autowired
    private CourseLessonRepository courseLessonRepository;

    public CourseLesson updateCourseLesson(CourseLesson courseLesson) {
        return courseLessonRepository.save(courseLesson);
    }

    public CourseLesson save(CourseLesson courseLesson){
        return courseLessonRepository.save(courseLesson);
    }
}
