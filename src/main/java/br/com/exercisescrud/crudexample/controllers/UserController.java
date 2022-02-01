package br.com.exercisescrud.crudexample.controllers;

import br.com.exercisescrud.crudexample.entitys.User;
import br.com.exercisescrud.crudexample.repository.UserRepository;
import br.com.exercisescrud.crudexample.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private UserRepository userRepo;




    //  View
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listUsers", userService.getAllUsers() );
        return "index";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormUpdate/{user_id}")
    public String showFormUpdate(@PathVariable (value = "user_id") int id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }



    @RequestMapping(value = "/createNewUser", method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute("user") User user){

        userService.createNewUser(user);
        return  "redirect:/";

    }

        @GetMapping("/deleteUserByID/{user_id}")
    public String deleteUserByID(@PathVariable(value = "user_id") int id){
        this.userService.deleteUserById(id);
        return  "redirect:/";
    }


}
