package learn.sphere.project.controller.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import learn.sphere.project.model.Course;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.model.UserCourses;
import learn.sphere.project.service.CourseService;
import learn.sphere.project.service.LessonService;
import learn.sphere.project.service.UserCoursesService;

@RestController
@RequestMapping("/rest-api/course/v1")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @Autowired 
    private UserCoursesService userCoursesService;


    @PostMapping("/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        try {
            courseService.saveCourse(course);
            return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createLesson")
    public ResponseEntity<String> createLesson(@RequestBody Lesson lesson) {
        try {
            lessonService.saveLesson(lesson);
            return new ResponseEntity<>("Lesson created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create lesson: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/purchaseCourse")
    public ResponseEntity<String> purchaseCourse(@RequestBody UserCourses userCourses) {
        try {
            userCoursesService.buyCourse(userCourses);
            return new ResponseEntity<>("Course purchased successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to purchase course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}