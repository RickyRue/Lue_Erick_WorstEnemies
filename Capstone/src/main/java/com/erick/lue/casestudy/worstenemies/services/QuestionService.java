package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.Question;
import com.erick.lue.casestudy.worstenemies.model.User;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    void saveQuestion(Question question);
    Question getQuestionById(long id);
    void deleteQuestionById(long id);
}

