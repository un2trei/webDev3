package com.mihai.MidtermTodos.service;

import com.mihai.MidtermTodos.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> findAllTodos();

    void createTodo(TodoDto todoDto);

    TodoDto findTodoById(Long todoId);

    void updateTodo(TodoDto todo);

    void deleteTodo(Long todoId);
}
