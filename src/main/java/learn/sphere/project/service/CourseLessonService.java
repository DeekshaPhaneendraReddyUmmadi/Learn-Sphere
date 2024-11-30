package learn.sphere.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.sphere.project.dto.CourseLessonDto;
import learn.sphere.project.model.CourseLesson;
import learn.sphere.project.repository.CourseLessonRepository;

@Service
public class CourseLessonService {


    @Autowired
    private CourseLessonRepository courseLessonRepository;

    public CourseLesson updateCourseLesson(CourseLesson courseLesson) {
        return courseLessonRepository.save(courseLesson);
    }

    public CourseLesson save(CourseLesson courseLesson){
        return courseLessonRepository.save(courseLesson);
    }

    public List<CourseLessonDto> getAllCoursesWithLessons() {
        // return courseLessonRepository.findAllCoursesWithLessons();
        List<CourseLessonDto> rawResults = courseLessonRepository.findAllCoursesWithLessons();
        Map<Long, CourseLessonDto> courseMap = new HashMap<>();
        
        for (CourseLessonDto dto : rawResults) {
            if (!courseMap.containsKey(dto.getCourseId())) {
                courseMap.put(dto.getCourseId(), dto);
                
            } else {
                CourseLessonDto existingDto = courseMap.get(dto.getCourseId());
                existingDto.getLessonNames().addAll(dto.getLessonNames());
            }
        }

        List<CourseLessonDto> finalResults = new ArrayList<>(courseMap.values());

        return finalResults;
    }
}