package com.todo.test.ToDoService;

import com.todo.test.entities.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    public List<ToDo> getFullList();

    public Optional<ToDo> getOneList(long listId);

    //public List<TodoList> getListName(String title);

    public void addList(ToDo todolist);

    public List<ToDo> addmultiList(List<ToDo> todolist);

    public ToDo updateList(ToDo todolist);

    public void deleteList(long listId);


}
