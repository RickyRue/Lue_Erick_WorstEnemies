package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import com.erick.lue.casestudy.worstenemies.repository.UserRepository;
import com.erick.lue.casestudy.worstenemies.repository.UserScoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScoresImpl implements  UserScoresService{

    private UserScoresRepository userScoresRepository;

    @Autowired
    public UserScoresImpl(UserScoresRepository userScoresRepository) {
        this.userScoresRepository = userScoresRepository;
    }

    @Override
    public List<UsersScores> getAllUsersScores() {
        return userScoresRepository.findAll();
    }

    @Override
    public void saveUsersScores(UsersScores usersScores) {
        this.userScoresRepository.save(usersScores);
    }
}
