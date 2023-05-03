package com.mihai.MidtermTodos.dto;


import com.mihai.MidtermTodos.entity.TaskStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private Long id;
    @NotEmpty(message = "Task description should not be empty")
    private String task;
    private Date dueDate;
    private TaskStatus status;


}
