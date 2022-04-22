package com.erick.lue.casestudy.worstenemies.repository;


import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserScoresRepositoryTest {
    @Autowired
    private UserScoresRepository userScoresRepository;

    @Test
    void findUsersEnemyList_given_valid_user_id(){
        List<UsersScores> usersScoresTest = userScoresRepository.findByUser1_IdOrderByScoreDesc(11L);
        Assertions.assertThat(usersScoresTest.size()).isEqualTo(1);
    }

}
