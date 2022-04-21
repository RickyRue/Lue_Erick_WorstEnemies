package com.erick.lue.casestudy.worstenemies.controller;

import com.erick.lue.casestudy.worstenemies.model.UsersScores;
import com.erick.lue.casestudy.worstenemies.services.UserScoresService;
import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class UserScoresController {

    private UserScoresService userScoresService;
    private UserService userService;

    @Autowired
    public UserScoresController(UserScoresService userScoresService, UserService userService){
        this.userScoresService = userScoresService;
        this.userService = userService;
    }

    @GetMapping("/allEnemiesScores")
    public String viewAllScores(Model model){

        model.addAttribute("listOfScores", userScoresService.getAllUsersScores());
        return "all_usersscores";

    }

    @GetMapping("/viewMyEnemies")
    public String viewMyEnemies(Model model){
        String username;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        long userId=userService.findByEmail(username).getId();

        List<UsersScores> myScoresList = userScoresService.findByUser1_Id(userId);

        model.addAttribute("myScoresList", myScoresList);
        return "view_my_enemies";
    }


}
