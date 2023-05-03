package com.mihai.MidtermTodos.controller;

import com.mihai.MidtermTodos.dto.TodoDto;
import com.mihai.MidtermTodos.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class TodoController {
    private TodoService todoService;
    public TodoController(TodoService todoService){this.todoService = todoService;}

//    handler method, GET request and return model and view
@GetMapping("/")
public String todos(Model model) {
    List<TodoDto> todos = todoService.findAllTodos();
    model.addAttribute("todos", todos);
    return "todos";
}



    //    handler method to handle new todo request
    @GetMapping("todos/newtodo")
    public String newTodoForm(Model model) {
        TodoDto todoDto = new TodoDto();
        model.addAttribute("todo", todoDto);
        return "create_todo";
    }

    //    handler method to handle form submit request
    @PostMapping("todos")
    public String createTodo(@Valid @ModelAttribute("todo") TodoDto todoDto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("todo", todoDto);
            return "create_todo";
        }
//        todoDto.setUrl(getUrl(todoDto.getTask()));
        todoService.createTodo(todoDto);
        return "redirect:todos";
    }

    //    handler method to handle edit todo request
    @GetMapping("todos/{todoId}/edit")
    public String editTodoForm(@PathVariable("todoId") Long todoId,
                               Model model) {
        TodoDto todoDto = todoService.findTodoById(todoId);
        model.addAttribute("todo", todoDto);
        return "edit_todo";
    }
    //    handler method to handle edit todo form submit request
    @PostMapping("todos/{todoId}")
    public String updateTodo(@PathVariable("todoId") Long todoId,
                             @Valid @ModelAttribute("todo") TodoDto todo,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("todo", todo);
            return "edit_todo";
        }
        todo.setId(todoId);
        todoService.updateTodo(todo);
        return "redirect:todos";
    }

    //    handler method to handle DELETE requests
    @GetMapping("todos/{todoId}/delete")
    public String deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
        return "redirect:todos";
    }
}
