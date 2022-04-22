package com.erick.lue.casestudy.worstenemies.repository;


import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserResponseRespository {
    @Autowired
    private UserResponseRepository userResponseRepository;

    @Test
    void findUserResponses_by_user_id_given_valid_userId(){

        List<UserResponse> userResponseTest = userResponseRepository.findByUserId(11L);
        Assertions.assertThat(userResponseTest.size()).isEqualTo(10);
    }

    @Test
    void findQuestion_given_valid_question_id(){
        List<UserResponse> userResponsesQuestionId = userResponseRepository.findByQuestionId(4);
        Assertions.assertThat(userResponsesQuestionId.size()).isEqualTo(2);
    }


}
