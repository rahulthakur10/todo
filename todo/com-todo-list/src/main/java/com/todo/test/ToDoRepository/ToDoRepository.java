package com.todo.test.ToDoRepository;

import com.todo.test.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}
