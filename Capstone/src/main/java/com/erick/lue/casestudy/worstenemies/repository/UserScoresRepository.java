package com.erick.lue.casestudy.worstenemies.repository;

import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserScoresRepository extends JpaRepository <UsersScores,Long> {
    List<UsersScores> findByUser1_IdOrderByScoreDesc(long userId1);


}
