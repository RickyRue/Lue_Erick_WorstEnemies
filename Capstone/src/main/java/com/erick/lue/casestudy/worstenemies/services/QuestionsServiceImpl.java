package com.erick.lue.casestudy.worstenemies.services;

import com.erick.lue.casestudy.worstenemies.model.Question;
import com.erick.lue.casestudy.worstenemies.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionsServiceImpl(QuestionRepository questionRepository){this.questionRepository = questionRepository;}

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void saveQuestion(Question question) {

        this.questionRepository.save(question);

    }

    @Override
    public Question getQuestionById(long id) {
        Question question = questionRepository.getById(id);
        if(question == null){
            throw new QuestionsNotFoundException();
        }
        return question;
    }

    @Override
    public void deleteQuestionById(long id) {

        questionRepository.deleteById(id);

    }
}
