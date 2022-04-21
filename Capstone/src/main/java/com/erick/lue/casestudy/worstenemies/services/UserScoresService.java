package com.erick.lue.casestudy.worstenemies.services;


import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserScoresService {
    List<UsersScores> findByUser1_Id(long userId1);
    List<UsersScores> getAllUsersScores();
    void saveUsersScores(UsersScores usersScores);
}
