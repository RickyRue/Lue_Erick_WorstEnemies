package com.erick.lue.casestudy.worstenemies.controller;

import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.services.UserRegistrationDto;
import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
@RequestMapping("/signup")

public class UserRegistrationController {


    @Autowired
    private UserService userService;


    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "signup";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "signup";
        }

        userService.save(userDto);
        return "redirect:/login";
    }
}


