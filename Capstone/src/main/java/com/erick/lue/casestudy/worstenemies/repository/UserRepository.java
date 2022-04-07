package com.erick.lue.casestudy.worstenemies.repository;

import com.erick.lue.casestudy.worstenemies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
