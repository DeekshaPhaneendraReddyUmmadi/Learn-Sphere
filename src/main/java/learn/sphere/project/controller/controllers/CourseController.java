package learn.sphere.project.controller.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;

import learn.sphere.project.dto.CourseLessonDto;
import learn.sphere.project.dto.CoursePurchasedLessonsDto;
import learn.sphere.project.dto.LessonsViewDto;
import learn.sphere.project.model.Account;
import learn.sphere.project.model.Course;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.service.CourseLessonService;
import learn.sphere.project.service.LessonService;
import learn.sphere.project.service.UserCoursesService;
// import learn.sphere.project.service.CourseService;
import learn.sphere.project.service.UsersService;
// import learn.sphere.project.dto.CourseLessonDto;
// import learn.sphere.project.dto.CoursePurchasedLessonsDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CourseController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private CourseLessonService courseLessonService;
    
    @Autowired
    private UserCoursesService userCoursesService;

    @Autowired
    private LessonService lessonService;

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
                // System.out.println(account.toString());
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
    @PreAuthorize("isAuthenticated()")
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
    @PreAuthorize("isAuthenticated()")
    public String course(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "/course/trainer/courseregister";
    }

    @GetMapping("/createLesson")
    @PreAuthorize("isAuthenticated()")
    public String lesson(Model model) {
        Lesson lesson = new Lesson();
        model.addAttribute("lesson", lesson);
        return "/course/trainer/lessonregister";
    }

    @GetMapping("/courses")
    @PreAuthorize("isAuthenticated()")
    public String getCourses(Model model) {
        List<CourseLessonDto> courses = courseLessonService.getAllCoursesWithLessons();
        model.addAttribute("courses", courses);
        return "/course/trainer/courseList";
    }
    
    @GetMapping("/purchase")
    @PreAuthorize("isAuthenticated()")
    public String purchase(Model model) {
        List<CourseLessonDto> courses = courseLessonService.getAllCoursesWithLessons();
        model.addAttribute("courses", courses);
        return "/course/student/courseList";
    }


    @GetMapping("/mycourses")
    @PreAuthorize("isAuthenticated()")
    public String purchasedList(Model model, Principal principal) {
        List<CoursePurchasedLessonsDto> purchasedList = new ArrayList<>();

        String authUser = principal != null ? principal.getName() : "email";
        Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            purchasedList = userCoursesService.getAllCoursesWithLessonsAccess(account.getId());
        } else {
            // Optionally log or handle the case where the account is not found
            // e.g., logger.warn("Account not found for email: " + authUser);
        }

        model.addAttribute("purchasedList", purchasedList);
        return "/course/student/purchasedcourse";
    }

    // working properly but need to update this method 
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/viewLesson/{lessonid}")
    @PreAuthorize("isAuthenticated()")
    public String viewLesson(@PathVariable("lessonid") Long lessonid, Model model, Principal principal) {
        Optional<Lesson> optionalLesson = lessonService.findAll(lessonid);
        Lesson lesson = optionalLesson.get();
        LessonsViewDto viewDtos = new LessonsViewDto();
        viewDtos.setLessonId(lesson.getLessonId());
        viewDtos.setLessonName(lesson.getLessonName());
        viewDtos.setLessonTopic(lesson.getLessonTopics());
    
        String lessonLink = lesson.getLessonLink();
        String[] link = lessonLink.split("\\?v=");
        if (link.length > 1) {
            viewDtos.setLessonLink(link[1]);
        } else {
            viewDtos.setLessonLink(""); // or handle the error appropriately
        }
    
        String comments = lesson.getComments();
        if (comments != null && !comments.isEmpty()) {
            String[] cmts = comments.split(",");
            List<String> cmtsList = Arrays.asList(cmts);
            viewDtos.setCmt(cmtsList);
        } else {
            viewDtos.setCmt(Collections.emptyList()); 
        }
        log.info(viewDtos.toString());
        model.addAttribute("lessons", viewDtos);
        return "/course/student/lessonView";
    }
    
}