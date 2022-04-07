package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){this.userRepository = userRepository;}

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {

        this.userRepository.save(user);

    }

    @Override
    public User getUserById(long id) {
        User user = userRepository.getById(id);
        if (user == null){
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public void deleteUserById(long id) {

        userRepository.deleteById(id);

    }

}
