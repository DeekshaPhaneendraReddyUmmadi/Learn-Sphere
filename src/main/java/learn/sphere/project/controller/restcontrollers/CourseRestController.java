package learn.sphere.project.controller.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import learn.sphere.project.model.Course;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.service.CourseService;
import learn.sphere.project.service.LessonService;

@RestController
@RequestMapping("/api/course/v1")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @PostMapping("/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/createLesson")
    public ResponseEntity<String> createLesson(@RequestBody Lesson lesson) {
        lessonService.saveLesson(lesson);
        return new ResponseEntity<>("Lesson created successfully", HttpStatus.CREATED);
    }
}
