package com.erick.lue.casestudy.worstenemies.controller;


import com.erick.lue.casestudy.worstenemies.model.User;
import com.erick.lue.casestudy.worstenemies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/admin")
    public String viewAdminPage(Model model){
        model.addAttribute("listUsers", userService.getAllUsers());

        return "admin";
    }

    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/profile")
    public String viewProfile(){
        return"profile";
    }

    @GetMapping("/cards")
    public String viewCards(){
        return"cards";
    }


    @GetMapping("/login")
    public String viewLogin() {

        return "login";
    }

    @GetMapping("/signup")
    public String viewNewUserSignUp(Model model) {
//         create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/saveUser")

    public String saveUser(@ModelAttribute ("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
    @PostMapping("/saveUserAdmin")

    public String saveUserAdmin(@ModelAttribute ("user") User user) {
        userService.saveUser(user);
        return "redirect:admin";
    }

    @GetMapping("/admin_update_user/{id}")
    public String showFormForUserUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        User user = userService.getUserById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "admin_update_user";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

}
