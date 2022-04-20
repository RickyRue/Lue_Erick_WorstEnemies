package com.erick.lue.casestudy.worstenemies.services;


import com.erick.lue.casestudy.worstenemies.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuestionServiceImpTest {

    @Autowired
    private QuestionService questionService;

    @Test
    void getAllQuestions(){
        List<Question> allQuestions = questionService.getAllQuestions();
        int beforeAddingMoreQuestions = allQuestions.size();

        Question question1 = new Question();
        question1.setFirst_text("Left");
        question1.setFirst_svg("Left.svg");
        question1.setSecond_text("Right");
        question1.setSecond_svg("Right.svg");
        questionService.saveQuestion(question1);
        int afterAddingMoreQuestions = questionService.getAllQuestions().size();

        Assertions.assertThat(afterAddingMoreQuestions).isEqualTo(beforeAddingMoreQuestions + 1);

    }

    @Test
    void getQuestionById(){
        List<Question> allQuestions = questionService.getAllQuestions();
        Question question1 = allQuestions.get(0);
        if (question1 != null){
            Question question2 = questionService.getQuestionById(1);
            Assertions.assertThat(question1).isEqualTo(question2);
        }
    }

}
