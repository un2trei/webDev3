package com.alex.blog.controller;

import com.alex.blog.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

//    handler method to handle user registration page request
//    http://localhost:8080/register
    @GetMapping("register")
    public String userRegistrationPage(Model model){
//        Empty UserForm model object to store form data
        UserForm userForm = new UserForm();
    model.addAttribute("userForm", userForm);
    List<String> listProffesion = Arrays.asList("Developer","Tester","Architect");
    model.addAttribute("listProffesion", listProffesion);
    return "register-form";
    }

//    handler method to handle user registration form submission request
//    http://localhost:8080/
    @PostMapping("register/save")
    public String submitForm(Model model,
    @ModelAttribute("userForm") UserForm userForm){
    model.addAttribute("userForm", userForm);
    return "register-success";
    }
}
