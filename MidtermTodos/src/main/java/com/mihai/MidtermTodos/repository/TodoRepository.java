package com.mihai.MidtermTodos.repository;

import com.mihai.MidtermTodos.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
