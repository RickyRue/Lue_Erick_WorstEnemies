package com.erick.lue.casestudy.worstenemies.controller;

import com.erick.lue.casestudy.worstenemies.model.Question;
import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.repository.QuestionRepository;
import com.erick.lue.casestudy.worstenemies.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class QuestionController {

    private QuestionService questionService;


    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/adminCards")
    public String viewAdminPageCards(Model model) {
        model.addAttribute("listQuestions", questionService.getAllQuestions());
        return "admin_questions";
    }

    @GetMapping("/showNewQuestionForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Question question = new Question();
        model.addAttribute("question", question);
        return "admin_new_question";
    }

    @PostMapping("/saveQuestion")
    public String saveQuestion(@ModelAttribute("question") @Valid Question question, BindingResult bindingResult) {

        // save question to database
        if (bindingResult.hasErrors()) {
            return "admin_new_question";
        }
        questionService.saveQuestion(question);

        return "redirect:/adminCards";
    }

    @GetMapping("/deleteQuestion/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete question method
        this.questionService.deleteQuestionById(id);
        return "redirect:/adminCards";
    }

    @GetMapping("/admin_update_question/{id}")
    public String showFormForUserUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Question question = questionService.getQuestionById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("question", question);
        return "admin_update_question";


    }
    @GetMapping("/cardsv2")
    public String viewCardsV2Page() {
        return "cardsv2";
    }

    @GetMapping("/cardsv3")
    public String viewCardsV3(Model model) {
        model.addAttribute("listQuestions", questionService.getAllQuestions());
        return "cardsv3";
    }



}
