package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserResponseService {
    List<UserResponse> findByUserId(long userId);
    List<UserResponse> getAllUserResponses();
    UserResponse saveUserResponse(UserResponse userResponse);

}
