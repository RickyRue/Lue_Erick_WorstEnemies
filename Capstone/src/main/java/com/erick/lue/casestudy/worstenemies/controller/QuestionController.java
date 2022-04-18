package com.erick.lue.casestudy.worstenemies.controller;

import com.erick.lue.casestudy.worstenemies.model.Question;
import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.repository.QuestionRepository;
import com.erick.lue.casestudy.worstenemies.services.QuestionService;
import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
public class QuestionController {

    private QuestionService questionService;

    private QuestionRepository questionRepository;

    private UserService userService;



    @Autowired
    public QuestionController(QuestionService questionService,  QuestionRepository questionRepository, UserService userService) {
        this.questionService = questionService;
        this.questionRepository = questionRepository;
        this.userService = userService;

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

    @GetMapping("/cards")
    public String viewCards() {
        return "cards";
    }

    @GetMapping("/cards/{id}")
    public String getQuestions(@PathVariable(value = "id") long id, Model model) {
        Question question = questionService.getQuestionById(id);

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        long userId=userService.findByEmail(username).getId();

        model.addAttribute("userId", userId);
        model.addAttribute("id", question.getId());
        model.addAttribute("first_text", question.getFirst_text());
        model.addAttribute("first_svg", question.getFirst_svg());
        model.addAttribute("second_text", question.getSecond_text());
        model.addAttribute("second_svg", question.getSecond_svg());
        return "cards";
    }





}
