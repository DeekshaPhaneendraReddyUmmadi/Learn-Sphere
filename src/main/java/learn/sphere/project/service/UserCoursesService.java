package learn.sphere.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sphere.project.dto.CoursePurchasedLessonsDto;
import learn.sphere.project.model.UserCourses;
import learn.sphere.project.repository.UserCoursesRepository;

@Service
public class UserCoursesService {

    @Autowired
    private UserCoursesRepository userCoursesRepository;

    public UserCourses buyCourse(UserCourses userCourses){
        return userCoursesRepository.save(userCourses);
    }

    public List<CoursePurchasedLessonsDto> getAllCoursesWithLessonsAccess(Long id) {
        return userCoursesRepository.findAllCoursesWithUserAccess(id);
    }

    public Optional<UserCourses> findUser(Long userid){
        return userCoursesRepository.findByUserId(userid);
    }
    
    public Optional<UserCourses> findUserCourse(Long userId, Long courseId) {
        return userCoursesRepository.findByUserIdAndCourseId(userId, courseId);
    }
    
}
    