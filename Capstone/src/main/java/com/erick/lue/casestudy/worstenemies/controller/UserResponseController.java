package com.erick.lue.casestudy.worstenemies.controller;


import com.erick.lue.casestudy.worstenemies.model.UserResponse;
import com.erick.lue.casestudy.worstenemies.services.UserResponseService;
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
import java.util.List;

@Controller
public class UserResponseController {

    private UserResponseService userResponseService;

    private UserService userService;


    @Autowired
    public UserResponseController(UserResponseService userResponseService,UserService userService){
        this.userResponseService = userResponseService;
        this.userService = userService;
    }



    @PostMapping("/saveUserResponse")
    public String saveUserResponse(@ModelAttribute("userResponse")@Valid UserResponse userResponse, BindingResult result){


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



//    @GetMapping("/myResponses/{id}")
//    public String viewMyResponses(@PathVariable(value = "id") long id,Model model){
//
//        List<UserResponse> myResponseList = userResponseService.findByUserId(id);
//        String username;
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails)principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
//        long userId=userService.findByEmail(username).getId();
//
//
//        model.addAttribute("myResponseList",myResponseList);
//        return "my_responses";
//    }







}
