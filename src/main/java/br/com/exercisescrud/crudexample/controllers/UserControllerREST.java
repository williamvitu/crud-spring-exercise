package br.com.exercisescrud.crudexample.controllers;


import br.com.exercisescrud.crudexample.entitys.User;
import br.com.exercisescrud.crudexample.repository.UserRepository;
import br.com.exercisescrud.crudexample.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserControllerREST {


    @Autowired
    private UserService userService;




    // Rest Services

    @GetMapping("/users")
    public List<User> listAllUsersHTTP(){

        return userService.getAllUsers();
    }

    @GetMapping("/users/{user_id}")
    public User listOneUser(@PathVariable int user_id){
        return userService.getUserById(user_id);
    }

    @PostMapping("/users/create")
    public User createNewUserHTTP(@RequestBody User newUser){

        return userService.createNewUserHTTP(newUser);
    }

    @DeleteMapping("/users/delete/{user_id}")
    public void deleteUserByIDHTTP(@PathVariable int user_id){
        userService.deleteUserById(user_id);
    }


    @PutMapping("users/{user_id}")
    public ResponseEntity <?> updateUserByID(@RequestBody User user, @PathVariable int user_id){

        try {
            userService.getUserById(user_id);
            userService.createNewUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
