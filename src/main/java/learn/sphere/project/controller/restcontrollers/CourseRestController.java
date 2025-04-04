package learn.sphere.project.controller.restcontrollers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import learn.sphere.project.dto.CommentAddDto;
import learn.sphere.project.dto.PurchaseRequestDto;
import learn.sphere.project.model.Account;
import learn.sphere.project.model.Course;
import learn.sphere.project.model.Lesson;
import learn.sphere.project.model.UserCourses;
import learn.sphere.project.service.CourseService;
import learn.sphere.project.service.LessonService;
import learn.sphere.project.service.UserCoursesService;
import learn.sphere.project.service.UsersService;
import learn.sphere.project.util.constant.Role;

@RestController
@RequestMapping("/rest-api/course/v1")
public class CourseRestController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private LessonService lessonService;

    @Autowired 
    private UserCoursesService userCoursesService;

    @Autowired
    private UsersService usersService;

    // @PostMapping("/createCourse")
    // public ResponseEntity<String> createCourse(@RequestBody Course course, Principal principal) {
    //     try {
    //         String authUser = "email";
    //         if(principal != null){
    //             authUser =  principal.getName();
    //         }
    //         Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
    //         if(optionalAccount.isPresent()) {
    //             Account account = optionalAccount.get();
    //             if(account.getRole().equals(Role.TRAINER)){
    //                 courseService.saveCourse(course);
    //             }
    //         }
    //         return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Failed to create course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PostMapping("/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody Course course, Principal principal) {
        try {
            String authUser = "email"; // Default value in case principal is null
            if (principal != null) {
                authUser = principal.getName();
            }
            
            Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                if (account.getRole().equals(Role.TRAINER)) {
                    courseService.saveCourse(course);
                    return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
                } else {
                    return new ResponseEntity<>("Access denied: User is not a trainer", HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @PostMapping("/createLesson")
    public ResponseEntity<String> createLesson(@RequestBody Lesson lesson, Principal principal) {
        try {
            String authUser = "email";
            if(principal != null){
                authUser =  principal.getName();
            }
            Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if(optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                if(account.getRole().equals(Role.TRAINER)){
                    lessonService.saveLesson(lesson);
                    return new ResponseEntity<>("Lesson created successfully", HttpStatus.CREATED);
                }else {
                    return new ResponseEntity<>("Access denied: User is not a trainer", HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create lesson: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/purchaseCourse")
    public ResponseEntity<String> purchaseCourse(@RequestBody PurchaseRequestDto purchaseRequestDto, Principal principal) {
        try {
            String authUser = "email";
            if (principal != null) {
                authUser = principal.getName();
            }
            
            // Fetch the user account based on the authenticated email
            Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                
                // Check if the user has the role of STUDENT
                if (account.getRole().equals(Role.STUDENT)) {
                    
                    // Check if the course exists
                    Optional<Course> optionalCourse = courseService.findCourse(purchaseRequestDto.getCourseId());
                    if (optionalCourse.isPresent()) {
                        
                        // Check if the user has already purchased this course
                        Optional<UserCourses> optionalUserCourses = userCoursesService.findUserCourse(account.getId(), purchaseRequestDto.getCourseId());
                        if (optionalUserCourses.isPresent()) {
                            return new ResponseEntity<>("Course already purchased", HttpStatus.CONFLICT);
                        } else {
                            // Create a new UserCourses object and proceed with the purchase
                            UserCourses userCourses = new UserCourses(account.getId(), purchaseRequestDto.getCourseId());
                            userCoursesService.buyCourse(userCourses);
                            return new ResponseEntity<>("Purchase successfully", HttpStatus.CREATED);
                        }
                    } else {
                        return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
                    }
                } else {
                    return new ResponseEntity<>("Access denied: User is not a student", HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to purchase course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // @PostMapping("/purchaseCourse")
    // public ResponseEntity<String> purchaseCourse(@RequestBody PurchaseRequestDto purchaseRequestDto, Principal principal) {
    //     try {
    //         String authUser = "email";
    //         if (principal != null) {
    //             authUser = principal.getName();
    //         }
    //         Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
    //         if (optionalAccount.isPresent()) {
    //             Account account = optionalAccount.get();
    //             if (account.getRole().equals(Role.STUDENT)) {
    //                 Optional<Course> optionalUserCourses = courseService.findCourse(purchaseRequestDto.getCourseId());
    //                 if (optionalUserCourses.isPresent()) {
    //                     UserCourses userCourses = new UserCourses(account.getId(), purchaseRequestDto.getCourseId());
    //                     System.out.println(optionalUserCourses.get().toString());
    //                     System.out.println(userCourses.toString());
    //                     userCoursesService.buyCourse(userCourses);
    //                     return new ResponseEntity<>("Purchase successfully", HttpStatus.CREATED);
    //                 } else {
    //                     return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    //                 }
    //             } else {
    //                 return new ResponseEntity<>("Access denied: User is not a student", HttpStatus.FORBIDDEN);
    //             }
    //         } else {
    //             return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Failed to purchase course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    


    // @PostMapping("/purchaseCourse")
    // public ResponseEntity<String> purchaseCourse(@RequestBody PurchaseRequestDto purchaseRequestDto, Principal principal) {
    //     try {
    //         String authUser = "email";
    //         if(principal != null){
    //             authUser =  principal.getName();
    //         }
    //         Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
    //         if(optionalAccount.isPresent()) {
    //             Account account = optionalAccount.get();
    //             if(account.getRole().equals(Role.STUDENT)){
    //                 Optional<UserCourses> optionalUserCourses = userCoursesService.findUser(purchaseRequestDto.getCourseId());
    //                 UserCourses userCourses = optionalUserCourses.get();
    //                 userCoursesService.buyCourse(userCourses);
    //                 return new ResponseEntity<>("Purchase successfully", HttpStatus.CREATED);
    //             }else {
    //                 return new ResponseEntity<>("Access denied: User is not a student", HttpStatus.FORBIDDEN);
    //             }
    //         } else {
    //             return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    //         }

    //         // return new ResponseEntity<>("Course purchased successfully", HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Failed to purchase course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    @PostMapping("/addComment")
    public ResponseEntity<String> addComment(@RequestBody CommentAddDto cmt, Principal principal) {
        try {
            String authUser = "email";
            if (principal != null) {
                authUser = principal.getName();
            }
            
            Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
            if (optionalAccount.isPresent()) {
                Account account = optionalAccount.get();
                if (account.getRole().equals(Role.STUDENT)) {
                    Optional<Lesson> optLsn = lessonService.findAll(cmt.getLessonid());
                    if (optLsn.isPresent()) {
                        Lesson lsn = optLsn.get();
                        lsn.setComments(lsn.getComments() + "," + cmt.getCmt());
                        lessonService.saveLesson(lsn);
                        return new ResponseEntity<>("Comment added successfully", HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>("Lesson not found", HttpStatus.NOT_FOUND);
                    }
                } else {
                    return new ResponseEntity<>("Access denied: User is not a student", HttpStatus.FORBIDDEN);
                }
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add comment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    // @PostMapping("/addComment")
    // public ResponseEntity<String> addComment(@RequestBody CommentAddDto cmt, Principal principal) {
    //     try {
    //         String authUser = "email";
    //         if(principal != null){
    //             authUser =  principal.getName();
    //         }
    //         Optional<Account> optionalAccount = usersService.getDetailsByEmail(authUser);
    //         if(optionalAccount.isPresent()) {
    //             Account account = optionalAccount.get();
    //             if(account.getRole().equals(Role.STUDENT)){
    //                 Optional<Lesson> optLsn = lessonService.findAll(cmt.getLessonid());
    //                 if(optLsn.isPresent()){
    //                     Lesson lsn = optLsn.get();
    //                     lsn.setComments(lsn.getComments() + "," + cmt.getCmt());
    //                     System.out.println(lsn.getComments());
    //                     lessonService.saveLesson(lsn);
    //                 }
    //             }
    //         }
    //         return new ResponseEntity<>("Course purchased successfully", HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>("Failed to purchase course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @PostMapping("/buyCourse")
    // public ResponseEntity<String> buyCourse(@RequestBody CommentAddDto c){
    //     return null;
    // }
}