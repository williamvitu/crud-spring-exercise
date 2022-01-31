package br.com.exercisescrud.crudexample.controllers;

import br.com.exercisescrud.crudexample.entitys.Course;
import br.com.exercisescrud.crudexample.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/showAllCourses")
    public String showAllCourses(Model model){
        Course course = new Course();
        model.addAttribute("listCourses", courseService.getAllCourses() );
        model.addAttribute("course", course);
        return "courses/courses_view";
    }

    @RequestMapping(value = "/createNewCourse", method = RequestMethod.POST)
    public String createNewCourse(@ModelAttribute("course") Course course){

        courseService.createNewCourse(course);
        //return  "redicourses/courses_view";
        return "redirect:/showAllCourses";
    }

    @GetMapping("/deleteCourseByID/{course_id}")
    public String deleteUserByID(@PathVariable(value = "course_id") int id){
        this.courseService.deleteCourse(id);
        return  "redirect:/showAllCourses";
    }
}
