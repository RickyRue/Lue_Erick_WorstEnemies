package com.erick.lue.casestudy.worstenemies.repository;

import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponse,Long> {

    List<UserResponse> findByUserId(long userId);
}
