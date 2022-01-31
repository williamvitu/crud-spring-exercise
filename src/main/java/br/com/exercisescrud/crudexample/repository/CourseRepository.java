package br.com.exercisescrud.crudexample.repository;

import br.com.exercisescrud.crudexample.entitys.Course;
import br.com.exercisescrud.crudexample.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository  extends JpaRepository <Course, Integer> {
}
