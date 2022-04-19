package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import com.erick.lue.casestudy.worstenemies.repository.UserRepository;
import com.erick.lue.casestudy.worstenemies.repository.UserResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResponseImpl implements UserResponseService {

    private UserResponseRepository userResponseRepository;

    private UserRepository userRepository;

    @Autowired
    public UserResponseImpl(UserResponseRepository userResponseRepository, UserRepository userRepository){
        this.userResponseRepository = userResponseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<UserResponse> findAllResponsesById(Long id) {
        userResponseRepository.findByUserId(id).getUser().getUserName();

        return this.userResponseRepository.findAll();
    }

    @Override
    public UserResponse saveUserResponse(UserResponse userResponse) {
        userResponse.setUser(userResponse.getUser());
        userResponse.setChoice(userResponse.isChoice());
        userResponse.setQuestion(userResponse.getQuestion());

        return userResponseRepository.save(userResponse);


    }


}
