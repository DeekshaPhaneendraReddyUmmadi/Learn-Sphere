package learn.sphere.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sphere.project.model.Course;
import learn.sphere.project.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> findCourse(Long courseId) {
        return courseRepository.findById(courseId);
    }
}
