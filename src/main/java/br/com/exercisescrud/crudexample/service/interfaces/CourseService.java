package br.com.exercisescrud.crudexample.service.interfaces;

import br.com.exercisescrud.crudexample.entitys.Course;



import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(int course_id);
    void createNewCourse(Course course);
    Course createNewCourseHTTP(Course course);
    void deleteCourse(int course_id);
}
