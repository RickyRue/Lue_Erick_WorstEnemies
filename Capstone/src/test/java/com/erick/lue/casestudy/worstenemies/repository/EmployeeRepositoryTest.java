package com.erick.lue.casestudy.worstenemies.repository;

import com.erick.lue.casestudy.worstenemies.model.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findFirstByEmail_should_return_Employee_given_valid_email() {

        User test =userRepository.findByEmail("test@mail.com");
        Assertions.assertThat(test.getEmail()).isEqualTo("test@mail.com");
    }
}