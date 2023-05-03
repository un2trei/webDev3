package com.complete.blog.controller;

import com.complete.blog.dto.RegistrationDto;
import com.complete.blog.entity.User;
import com.complete.blog.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    //    handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistratioForm(Model model){
//      this object holds form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

//    handler method to handle user form submission request
    @PostMapping("/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model){
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() !=null && existingUser.getEmail().isEmpty()){
        result.rejectValue("email", null, "There is already a user registered with this email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }

        userService.saveUser(user);
        return "redirect:/register?success";
    }

}
