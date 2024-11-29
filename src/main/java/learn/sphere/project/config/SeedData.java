package learn.sphere.project.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import learn.sphere.project.model.Account;
import learn.sphere.project.model.Course;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.service.CourseService;
import learn.sphere.project.service.LessonService;
import learn.sphere.project.service.UsersService;
import learn.sphere.project.util.constant.Role;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @Override
    public void run(String... args) throws Exception {
        // users
        Account user1 = new Account("AliceJohnson", "alice.johnson@gmail.com", "pass", Role.STUDENT);
        usersService.save(user1);

        Account user2 = new Account("JohnDoe", "john.doe@gmail.com", "pass", Role.TRAINER);
        usersService.save(user2);

        Account user3 = new Account("JaneSmith", "jane.smith@gmail.com", "pass", Role.ADMIN);
        usersService.save(user3);

        //course

        Course mathCourse = new Course(111L, "Math", 100.0);
        courseService.saveCourse(mathCourse);

        Course scienceCourse = new Course(112L, "Science", 150.0);
        courseService.saveCourse(scienceCourse);

        List<String> lessons = new ArrayList<>();
        lessons.add("Algebra");

        // lesson
        Lesson algebraLesson = new Lesson(1001L, 111L, lessons, "link1", "Algebra");
        lessonService.saveLesson(algebraLesson);

        lessons.clear();
        lessons.add("Geometry");
        
        Lesson geometryLesson = new Lesson(1002L, 111L, lessons, "link2", "Geometry");
        lessonService.saveLesson(geometryLesson);
        
        lessons.clear();
        lessons.add("Biology");

        Lesson biologyLesson = new Lesson(1003L, 112L, lessons, "link3", "Cell Biology");
        lessonService.saveLesson(biologyLesson);

    }

}
