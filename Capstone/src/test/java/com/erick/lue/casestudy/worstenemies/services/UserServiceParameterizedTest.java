package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceParameterizedTest {


    @InjectMocks
    UserServiceImpl userServiceImpl;


    @Mock
    private UserRepository userRepository;


    @ParameterizedTest
    @MethodSource("input")
    void getUserById_should_return_correct_user_given_id(User user){
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        User actualUser = userServiceImpl.getUserById(user.getId());
        Assertions.assertThat(actualUser).isEqualTo(user);
    }
    static Stream<Arguments> input() {
        User expectedUser1 = new User();
        expectedUser1.setId(11L);
        expectedUser1.setEmail("testUser1@mail.com");
        expectedUser1.setUserName("testUser1");
        expectedUser1.setPassword("Abcd12345!");

        User expectedUser2 = new User();
        expectedUser2.setId(12L);
        expectedUser2.setEmail("testUser2@mail.com");
        expectedUser2.setUserName("testUser2");
        expectedUser2.setPassword("Abcd12345!");

        User expectedUser3 = new User();
        expectedUser3.setId(13L);
        expectedUser3.setEmail("testUser3@mail.com");
        expectedUser3.setUserName("testUser3");
        expectedUser3.setPassword("Abcd12345!");

        return Stream.of(
                arguments(
                        expectedUser1
                ),
                arguments(
                        expectedUser2
                ),
                arguments(
                        expectedUser3
                )

        );

    }

    }


