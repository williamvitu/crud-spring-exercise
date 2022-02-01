package br.com.exercisescrud.crudexample.controllers;

import br.com.exercisescrud.crudexample.entitys.Course;
import br.com.exercisescrud.crudexample.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

public class CourseControllerREST {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> listAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{course_id}")
    public Course listOneCourse(@PathVariable int course_id){

        return courseService.getCourseById(course_id);

    }

    @PostMapping("/courses/create")
    public Course createNewCourse(@RequestBody Course newCourse){
        return courseService.createNewCourseHTTP(newCourse);
    }

    @DeleteMapping("/courses/delete/{course_id}")
    public void deleteCourseByID(@PathVariable int course_id){
        courseService.deleteCourse(course_id);
    }


    @PutMapping("/courses/{course_id}")
    public ResponseEntity <?> updateCourseByID(@RequestBody Course course, @PathVariable int course_id){

        try
        {
            courseService.getCourseById(course_id);
            courseService.createNewCourse(course);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
