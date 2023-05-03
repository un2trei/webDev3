package com.mihai.MidtermTodos.mapper;

import com.mihai.MidtermTodos.dto.TodoDto;
import com.mihai.MidtermTodos.entity.Todo;

public class TodoMapper {
    public static TodoDto mapToTodoDto(Todo todo){
        return TodoDto.builder()
                .id(todo.getId())
                .task(todo.getTask())
                .dueDate(todo.getDueDate())
                .status(todo.getStatus())
                .build();
    }

    public static Todo mapToTodo(TodoDto todoDto){
        return Todo.builder()
                .id(todoDto.getId())
                .task(todoDto.getTask())
                .dueDate(todoDto.getDueDate())
                .status(todoDto.getStatus())
                .build();
    }
}
