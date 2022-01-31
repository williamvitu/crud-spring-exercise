package br.com.exercisescrud.crudexample.service;

import br.com.exercisescrud.crudexample.entitys.User;
import br.com.exercisescrud.crudexample.repository.UserRepository;
import br.com.exercisescrud.crudexample.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void createNewUser(User user) {
        this.userRepo.save(user);
    }

    @Override
    public User getUserById(int user_id) {

        Optional <User> optional = userRepo.findById(user_id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();

        } else{
            throw new RuntimeException("Employee not found for id ::"+ user_id);
        }
        return user;
    }

    @Override
    public void  deleteUserById(int user_id) {
        this.userRepo.deleteById(user_id);

    }



}
