package br.com.exercisescrud.crudexample.service.interfaces;

import br.com.exercisescrud.crudexample.entitys.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void createNewUser(User user);
    User createNewUserHTTP(User user);
    User getUserById(int user_id);
    void deleteUserById(int user_id);


}
