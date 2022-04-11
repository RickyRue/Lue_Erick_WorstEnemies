package com.erick.lue.casestudy.worstenemies.repository;

import com.erick.lue.casestudy.worstenemies.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
