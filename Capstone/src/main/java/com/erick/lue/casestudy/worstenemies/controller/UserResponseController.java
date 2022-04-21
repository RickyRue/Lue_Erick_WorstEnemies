package com.erick.lue.casestudy.worstenemies.controller;


import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import com.erick.lue.casestudy.worstenemies.services.UserResponseService;
import com.erick.lue.casestudy.worstenemies.services.UserScoresService;
import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserResponseController {

    private UserResponseService userResponseService;
    
    private UserScoresService userScoresService;
    
    private UserService userService;


    @Autowired
    public UserResponseController(UserResponseService userResponseService,UserService userService,  UserScoresService userScoresService){
        this.userResponseService = userResponseService;
        this.userService = userService;
        this.userScoresService = userScoresService;
    }



    @PostMapping("/saveUserResponse")
    public String saveUserResponse(@Valid UserResponse userResponse, BindingResult result){


        userResponseService.saveUserResponse(userResponse);

        return "redirect:/cards";
    }
    @GetMapping("/allUserResponses")
    public String viewAllResponses(Model model){

        model.addAttribute("listResponses", userResponseService.getAllUserResponses());
        return "all_responses";
    }

    @GetMapping("/myResponses")
    public String viewMyResponses(Model model){

        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        long userId=userService.findByEmail(username).getId();

        List<UserResponse> myResponseList = userResponseService.findByUserId(userId);

        model.addAttribute("myResponseList",myResponseList);
        return "my_responses";
    }

    @GetMapping("/enemies")
    public String myEnemies(){
        HashMap<Long, Integer> scores = new HashMap<>();
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userService.findByEmail(username);
        long userId= user.getId();

        List<UserResponse> myResponseList = userResponseService.findByUserId(userId);


        for (UserResponse myResponse : myResponseList)
        {
            System.out.println("THIS IS MY RESPONSE LIST" +myResponse);
            List<UserResponse> thisQuestionResponses = userResponseService.findByUserId(myResponse.getQuestion().getId());
            System.out.println("THIS IS MY QUESTION RESPONSE" +thisQuestionResponses);
                for (UserResponse thisQuestionResponse: thisQuestionResponses)


                 {
                     System.out.println("THIS IS QUESTION RESPONSE" +thisQuestionResponse);
                     long thisQuestionUserId = thisQuestionResponse.getUser().getId();
                     if (thisQuestionUserId == userId) {
                     continue;
                 }
                   if (thisQuestionResponse.isChoice() != myResponse.isChoice()){

                       Integer score = scores.get(thisQuestionUserId);
                       if (score == null ){
                           score = 0;
                       }
                       score++;
                       scores.put(thisQuestionUserId,score);


                 }

                 }



        }
        System.out.println("THIS IS MY SCORE" + scores);
        scores.forEach((enemyId, enemyScore) ->{
            UsersScores usersScores = new UsersScores();
            usersScores.setScore(enemyScore);
            usersScores.setUser1(user);
            usersScores.setUser2(userService.getUserById(enemyId));
            userScoresService.saveUsersScores(usersScores);


        });


        return "myenemies";
    }











}
