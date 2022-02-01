package br.com.exercisescrud.crudexample.service;

import br.com.exercisescrud.crudexample.entitys.Course;
import br.com.exercisescrud.crudexample.entitys.User;
import br.com.exercisescrud.crudexample.repository.CourseRepository;
import br.com.exercisescrud.crudexample.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<Course> getAllCourses() {return this.courseRepo.findAll();}

    @Override
    public Course getCourseById(int course_id) {
        Optional<Course> optional = courseRepo.findById(course_id);
        Course course = null;
        if(optional.isPresent()){
            course = optional.get();

        } else{
            throw new RuntimeException("Employee not found for id ::"+ course_id);
        }
        return course;
    }

    @Override
    public void createNewCourse(Course course) {this.courseRepo.save(course);}

    @Override
    public Course createNewCourseHTTP(Course course) {
        return this.courseRepo.save(course);
    }

    @Override
    public void deleteCourse(int course_id) {
        this.courseRepo.deleteById(course_id);
    }


}
