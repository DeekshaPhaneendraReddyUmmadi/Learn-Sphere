package learn.sphere.project.controller.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// import learn.sphere.project.dto.CourseLessonDto;
import learn.sphere.project.model.Account;
import learn.sphere.project.model.Course;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.service.CourseLessonService;
import learn.sphere.project.service.UsersService;
import learn.sphere.project.dto.CourseLessonDto;

@Controller
public class CourseController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CourseLessonService courseLessonService;

    @GetMapping("/student")
    @PreAuthorize("isAuthenticated()")
    public String studentHome(Model model, Principal principal){
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                model.addAttribute( "account", account);
                return  "/course/student/studentHome";
        }else{
            return "redirect:/?error";
        }
    }
    
    @GetMapping("/trainer")
    @PreAuthorize("isAuthenticated()")
    public String  trainerHome(Model model, Principal principal){
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }

        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                System.out.println(account.toString());
                model.addAttribute( "account", account);
                return  "/course/trainer/trainerHome";
        }else{
            return "redirect:/error";
        }
    }
    
    @GetMapping("/adminHome")
    @PreAuthorize("isAuthenticated()")
    public String adminHome(Model model, Principal principal){
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                model.addAttribute( "account", account);
                return  "/course/admin/adminHome";
        }else{
            return "redirect:/?error";
        }
    }

    @GetMapping("/redirect")
    public String redirectBasedOnRole(Principal principal) {
        String redirectUrl = "/";
        String authUser = "email";
        if(principal != null){
            authUser =  principal.getName();
        }
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
        if(optionalAccount.isPresent()) {
            Account user = optionalAccount.get();
            
            if (user != null) {
                switch (user.getRole()) {
                    case ADMIN:
                        redirectUrl = "/adminHome";
                        break;
                    case TRAINER:
                        redirectUrl = "/trainer";
                        break;
                    case STUDENT:
                        redirectUrl = "/student";
                        break;
                    default:
                        break;
                }
            }
        }
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/createCourse")
    public String course(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "/course/trainer/courseregister";
    }

    @GetMapping("/createLesson")
    public String lesson(Model model) {
        Lesson lesson = new Lesson();
        model.addAttribute("lesson", lesson);
        return "/course/trainer/lessonregister";
    }

    @GetMapping("/courses")
    public String getCourses(Model model) {
        List<CourseLessonDto> courses = courseLessonService.getAllCoursesWithLessons();
        model.addAttribute("courses", courses);
        // model.addAttribute("text", "hello world!");
        return "/course/trainer/courseList"; // The name of your HTML file without the .html extension
    }

    // @GetMapping("/list")
    // public String getCourseslist(Model model) {
    //     // List<CourseLessonDto> courses = courseLessonService.getAllCoursesWithLessons();
    //     // model.addAttribute("courses", courses);
    //     // model.addAttribute("text", "hello world!");
    //     return "/course/trainer/courseList"; // The name of your HTML file without the .html extension
    // }
}
