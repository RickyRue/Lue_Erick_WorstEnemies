package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import com.erick.lue.casestudy.worstenemies.repository.QuestionRepository;
import com.erick.lue.casestudy.worstenemies.repository.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserResponseImpl implements UserResponseService {

    private UserResponseRepository userResponseRepository;

    @Autowired
    public UserResponseImpl(UserResponseRepository userResponseRepository){this.userResponseRepository = userResponseRepository;}


    @Override
    public void saveUserResponse(UserResponse userResponse) {

    }
}
