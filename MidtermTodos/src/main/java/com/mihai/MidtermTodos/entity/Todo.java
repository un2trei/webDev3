package com.mihai.MidtermTodos.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Length(max = 100, min = 1)

    private String task;
    private Date dueDate;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

}
