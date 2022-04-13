package com.erick.lue.casestudy.worstenemies.controller;


import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import com.erick.lue.casestudy.worstenemies.services.UserResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserResponseController {

    private UserResponseService userResponseService;

    @Autowired
    public UserResponseController(UserResponseService userResponseService){
        this.userResponseService = userResponseService;
    }



    @PostMapping("/saveUserResponse")
    public String saveUserResponse(@ModelAttribute("userResponse")@Valid UserResponse userResponse, BindingResult bindingResult){
        userResponseService.saveUserResponse(userResponse);
        return null;
    }


}
