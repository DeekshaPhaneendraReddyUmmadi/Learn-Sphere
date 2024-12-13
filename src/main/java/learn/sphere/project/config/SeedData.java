package learn.sphere.project.config;

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
        // Users
        Account user1 = new Account("Alice Johnson", "alice.johnson@gmail.com", "pass", Role.STUDENT);
        usersService.save(user1);

        Account user2 = new Account("John Doe", "john.doe@gmail.com", "pass", Role.TRAINER);
        usersService.save(user2);

        Account user3 = new Account("Jane Smith", "jane.smith@gmail.com", "pass", Role.ADMIN);
        usersService.save(user3);

        // Courses
        Course mathCourse = new Course(111L, "Math", 100.0);
        courseService.saveCourse(mathCourse);

        Course scienceCourse = new Course(112L, "Science", 150.0);
        courseService.saveCourse(scienceCourse);

        Course historyCourse = new Course(113L, "History", 120.0);
        courseService.saveCourse(historyCourse);

        Course literatureCourse = new Course(114L, "Literature", 130.0);
        courseService.saveCourse(literatureCourse);

        Course computerScienceCourse = new Course(115L, "Computer Science", 200.0);
        courseService.saveCourse(computerScienceCourse);

        Course artCourse = new Course(116L, "Art", 90.0);
        courseService.saveCourse(artCourse);

        Course physicalEducationCourse = new Course(117L, "Physical Education", 80.0);
        courseService.saveCourse(physicalEducationCourse);

        // Lessons
        lessonService.saveLesson(new Lesson(1001L, 111L, "Algebra", "https://www.youtube.com/watch?v=aS0t9HTO5V4", "Algebra Topics", "The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1002L, 111L, "Geometry", "https://www.youtube.com/watch?v=S2xyFQlpzIY", "Geometry Topics", "good,Great introduction! I learned a lot."));
        lessonService.saveLesson(new Lesson(1003L, 112L, "Biology", "https://www.youtube.com/watch?v=3tisOnOkwzo", "Cell Biology", "good,The examples were very helpful. Thank you!"));
        lessonService.saveLesson(new Lesson(1004L, 112L, "Physics", "https://www.youtube.com/watch?v=ZAqIoDhornk", "Physics Fundamentals", "good, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1005L, 113L, "Chemistry", "https://www.youtube.com/watch?v=5iTOphGnCtg", "Chemistry Basics", "good, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1006L, 113L, "World War I", "https://www.youtube.com/watch?v=dHSQAEam2yc", "WWI Overview", "good,The examples were very helpful. Thank you!"));
        lessonService.saveLesson(new Lesson(1007L, 113L, "Renaissance", "https://www.youtube.com/watch?v=Om1jvUzVAtE", "Renaissance Era", "good, The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1008L, 114L, "Shakespeare", "https://www.youtube.com/watch?v=y94RsqtEADQ", "Shakespeare's Works", "good,The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1009L, 114L, "Poetry", "https://www.youtube.com/watch?v=JwhouCNq-Fc", "Poetry Fundamentals", "good,The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1010L, 115L, "Programming Basics", "https://www.youtube.com/watch?v=zOjov-2OZ0E", "Introduction to Programming","The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1011L, 115L, "Data Structures", "https://www.youtube.com/watch?v=8hly31xKli0", "Data Structures Concepts","The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1012L, 115L, "Algorithms", "https://www.youtube.com/watch?v=8hly31xKli0", "Algorithm Design","good, The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1013L, 116L, "Painting Techniques", "https://www.youtube.com/watch?v=cDzcoyeaRKI", "Basic Painting Skills", "good, The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1014L, 116L, "Sculpture Basics", "https://www.youtube.com/watch?v=1n7apcgQiz0", "Introduction to Sculpting","The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
        lessonService.saveLesson(new Lesson(1015L, 117L, "Fitness Training", "https://www.youtube.com/watch?v=37UhELFvPec", "Exercise Techniques", "good,Great introduction! I learned a lot."));
        lessonService.saveLesson(new Lesson(1016L, 117L, "Team Sports", "https://www.youtube.com/watch?v=PMpZukqYpH4", "Teamwork in Sports","The examples were very helpful. Thank you!, I found this lesson a bit challenging, but I enjoyed it."));
    }
}
