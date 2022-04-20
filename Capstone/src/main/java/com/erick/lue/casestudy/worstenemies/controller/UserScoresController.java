package com.erick.lue.casestudy.worstenemies.controller;

import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import com.erick.lue.casestudy.worstenemies.services.UserScoresService;
import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class UserScoresController {

    private UserScoresService userScoresService;
    private UserService userService;

    @Autowired
    public UserScoresController(UserScoresService userScoresService, UserService userService){
        this.userScoresService = userScoresService;
        this.userService = userService;
    }

    @GetMapping("/myenemies")
    public String viewListofMyEnemies(Model model){
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        long userId=userService.findByEmail(username).getId();

        List<UsersScores> myEnemies = userScoresService.findByUserId(userId);
        model.addAttribute("myEnemies", myEnemies);

    }
}
