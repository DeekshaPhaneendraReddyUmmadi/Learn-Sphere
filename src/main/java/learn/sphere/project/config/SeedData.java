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


        //new data


        // Creating more courses
        Course historyCourse = new Course(113L, "History", 120.0);
        courseService.saveCourse(historyCourse);

        Course literatureCourse = new Course(114L, "Literature", 130.0);
        courseService.saveCourse(literatureCourse);

        // Creating lessons for Math course
        List<String> mathLessons = new ArrayList<>();
        mathLessons.add("Trigonometry");
        Lesson trigonometryLesson = new Lesson(1004L, 111L, mathLessons, "link4", "Trigonometry");
        lessonService.saveLesson(trigonometryLesson);

        mathLessons.clear();
        mathLessons.add("Calculus");
        Lesson calculusLesson = new Lesson(1005L, 111L, mathLessons, "link5", "Calculus");
        lessonService.saveLesson(calculusLesson);

        // Creating lessons for Science course
        List<String> scienceLessons = new ArrayList<>();
        scienceLessons.add("Physics");
        Lesson physicsLesson = new Lesson(1006L, 112L, scienceLessons, "link6", "Physics");
        lessonService.saveLesson(physicsLesson);

        scienceLessons.clear();
        scienceLessons.add("Chemistry");
        Lesson chemistryLesson = new Lesson(1007L, 112L, scienceLessons, "link7", "Chemistry");
        lessonService.saveLesson(chemistryLesson);

        // Creating lessons for History course
        List<String> historyLessons = new ArrayList<>();
        historyLessons.add("World War I");
        Lesson ww1Lesson = new Lesson(1008L, 113L, historyLessons, "link8", "World War I");
        lessonService.saveLesson(ww1Lesson);

        historyLessons.clear();
        historyLessons.add("Renaissance");
        Lesson renaissanceLesson = new Lesson(1009L, 113L, historyLessons, "link9", "Renaissance");
        lessonService.saveLesson(renaissanceLesson);

        // Creating lessons for Literature course
        List<String> literatureLessons = new ArrayList<>();
        literatureLessons.add("Shakespeare");
        Lesson shakespeareLesson = new Lesson(1010L, 114L, literatureLessons, "link10", "Shakespeare");
        lessonService.saveLesson(shakespeareLesson);

        literatureLessons.clear();
        literatureLessons.add("Poetry");
        Lesson poetryLesson = new Lesson(1011L, 114L, literatureLessons, "link11", "Poetry");
        lessonService.saveLesson(poetryLesson);


        // few more 

        // Creating more courses with different names
        Course computerScienceCourse = new Course(115L, "Computer Science", 200.0);
        courseService.saveCourse(computerScienceCourse);

        Course artCourse = new Course(116L, "Art", 90.0);
        courseService.saveCourse(artCourse);

        Course physicalEducationCourse = new Course(117L, "Physical Education", 80.0);
        courseService.saveCourse(physicalEducationCourse);

        // Creating lessons for Computer Science course
        List<String> csLessons = new ArrayList<>();
        csLessons.add("Introduction to Programming");
        Lesson introProgrammingLesson = new Lesson(1012L, 115L, csLessons, "link12", "Introduction to Programming");
        lessonService.saveLesson(introProgrammingLesson);

        csLessons.clear();
        csLessons.add("Data Structures");
        Lesson dataStructuresLesson = new Lesson(1013L, 115L, csLessons, "link13", "Data Structures");
        lessonService.saveLesson(dataStructuresLesson);

        csLessons.clear();
        csLessons.add("Algorithms");
        Lesson algorithmsLesson = new Lesson(1014L, 115L, csLessons, "link14", "Algorithms");
        lessonService.saveLesson(algorithmsLesson);

        // Creating lessons for Art course
        List<String> artLessons = new ArrayList<>();
        artLessons.add("Painting Techniques");
        Lesson paintingTechniquesLesson = new Lesson(1015L, 116L, artLessons, "link15", "Painting Techniques");
        lessonService.saveLesson(paintingTechniquesLesson);

        artLessons.clear();
        artLessons.add("Sculpture Basics");
        Lesson sculptureBasicsLesson = new Lesson(1016L, 116L, artLessons, "link16", "Sculpture Basics");
        lessonService.saveLesson(sculptureBasicsLesson);

        // Creating lessons for Physical Education course
        List<String> peLessons = new ArrayList<>();
        peLessons.add("Fitness Training");
        Lesson fitnessTrainingLesson = new Lesson(1017L, 117L, peLessons, "link17", "Fitness Training");
        lessonService.saveLesson(fitnessTrainingLesson);

        peLessons.clear();
        peLessons.add("Team Sports");
        Lesson teamSportsLesson = new Lesson(1018L, 117L, peLessons, "link18", "Team Sports");
        lessonService.saveLesson(teamSportsLesson);


        // List<String> csLessons = new ArrayList<>();

        // Add a lesson on Introduction to Programming
        // csLessons.add("Introduction to Programming");
        // Lesson introProgrammingLesson = new Lesson(1004L, 113L, csLessons, "link4", "Introduction to Programming");
        // lessonService.saveLesson(introProgrammingLesson);
        
        // Clear the list and add a lesson on Object-Oriented Programming
        csLessons.clear();
        csLessons.add("Object-Oriented Programming");
        Lesson oopLesson = new Lesson(1055L, 115L, csLessons, "link5", "Object-Oriented Programming");
        lessonService.saveLesson(oopLesson);
        
        // Clear the list and add a lesson on Web Development
        csLessons.clear();
        csLessons.add("Web Development");
        Lesson webDevelopmentLesson = new Lesson(1056L, 115L, csLessons, "link6", "Web Development");
        lessonService.saveLesson(webDevelopmentLesson);
        
        // Clear the list and add a lesson on Database Management
        csLessons.clear();
        csLessons.add("Database Management");
        Lesson databaseManagementLesson = new Lesson(1057L, 115L, csLessons, "link7", "Database Management");
        lessonService.saveLesson(databaseManagementLesson);
        
        // Clear the list and add a lesson on Software Engineering
        csLessons.clear();
        csLessons.add("Software Engineering");
        Lesson softwareEngineeringLesson = new Lesson(1058L, 115L, csLessons, "link8", "Software Engineering");
        lessonService.saveLesson(softwareEngineeringLesson);

    }

}
