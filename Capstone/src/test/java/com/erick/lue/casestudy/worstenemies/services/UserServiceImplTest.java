package com.erick.lue.casestudy.worstenemies.services;


import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;


@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        int beforeAddingMoreUsers = allUsers.size();

        User user1 = new User();
        user1.setUserName("Test2");
        user1.setEmail("test2@mail.com");
        user1.setPassword("Abcd1234!");
        userService.saveUser(user1);
        int afterAddingMoreUsers = userService.getAllUsers().size();

        Assertions.assertThat(afterAddingMoreUsers).isEqualTo(beforeAddingMoreUsers + 1);
        Assertions.assertThat(allUsers.contains(user1));
    }

    @Test
    void getUserById() {
        List<User> allUsers = userService.getAllUsers();
        User user1 = allUsers.get(0);
        if (user1 != null) {
            User user2 = userService.getUserById(10);
            Assertions.assertThat(user1).isEqualTo(user2);
        }
    }


    }
