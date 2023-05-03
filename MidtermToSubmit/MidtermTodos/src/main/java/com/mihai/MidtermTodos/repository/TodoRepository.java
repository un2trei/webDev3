package com.mihai.MidtermTodos.repository;

import com.mihai.MidtermTodos.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
