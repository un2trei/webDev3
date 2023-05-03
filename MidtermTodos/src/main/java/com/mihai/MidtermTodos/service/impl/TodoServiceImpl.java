package com.mihai.MidtermTodos.service.impl;

import com.mihai.MidtermTodos.dto.TodoDto;
import com.mihai.MidtermTodos.entity.Todo;
import com.mihai.MidtermTodos.mapper.TodoMapper;
import com.mihai.MidtermTodos.repository.TodoRepository;
import com.mihai.MidtermTodos.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;
    public TodoServiceImpl(TodoRepository todoRepository){this.todoRepository = todoRepository;}

    @Override
    public List<TodoDto> findAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(TodoMapper::mapToTodoDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.mapToTodo(todoDto);
        todoRepository.save(todo);
    }

    @Override
    public TodoDto findTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId).get();
        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public void updateTodo(TodoDto todoDto) {
        Todo todo = TodoMapper.mapToTodo(todoDto);
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
