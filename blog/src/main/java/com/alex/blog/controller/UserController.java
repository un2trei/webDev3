package com.alex.blog.controller;

import com.alex.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController{

//    handler method to handle variable-expression request
//    http://localhost:8080/variable-expression
    @GetMapping("variable-expression")
    public String variableExpression(Model model){
        User user = new User("alex", "alex@gmail.com", "ADMIN", "M");
        model.addAttribute("user", user);
        return "variable-expression";
    }

//    handler method to handle selection expressions
//    http://localhost:8080/selection-expression
    @GetMapping("selection-expression")
    public String selectionExpression(Model model){
        User user = new User("alex", "alex@gmail.com", "ADMIN", "M");
        model.addAttribute("user", user);
        return "selection-expression";
    }

//    handler method to handle message expressions
//    http://localhost:8080/message-expression
    @GetMapping("message-expression")
    public String messageExpression (){
    return "message-expression";
    }


//    handler method to handle link expressions
//    http://localhost:8080/link-expression
    @GetMapping("link-expression")
    public String linkExpression (Model model){
        model.addAttribute("id",1);
        return "link-expression";
    }

//    handler method to handle fragment expressions
//    http://localhost:8080/fragment-expression
    @GetMapping("fragment-expression")
    public String fragmentExpression (){
        return "fragment-expression";
    }
//    handler method to handle iteration + status of iterated items
//    http://localhost:8080/users
    @GetMapping("/users")
    public String users (Model model){
    User admin = new User("Admin", "admin@gmail.com", "ADMIN", "male");
    User alex = new User("Alex","alex@gmail.com", "USER", "male");
    User meena = new User("Meena", "meena@gmail.com", "USER", "female");
    List<User> users = new ArrayList<>();
    users.add(admin);
    users.add(alex);
    users.add(meena);
    model.addAttribute("users", users);
    return "users";
    }
//    handler method to handle if / unless
//    http://localhost:8080/if-unless
    @GetMapping("/if-unless")
    public String ifUnless(Model model){
        User admin = new User("Admin", "admin@gmail.com", "ADMIN", "male");
        User alex = new User("Alex","alex@gmail.com", "USER", "male");
        User meena = new User("Meena", "meena@gmail.com", "USER", "female");
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(alex);
        users.add(meena);
        model.addAttribute("users", users);
        return "if-unless";
    }
//    handler method to handle switch case
//    http://localhost:8080/switch-case
    @GetMapping("switch-case")
    public String switchCase(Model model){
        User user = new User("Alex", "admin@gmail.com", "ADMIN", "male");
     model.addAttribute("user", user);
     return "switch-case";
    }
}
