package com.todo.test.ToDoService;

import com.todo.test.ToDoRepository.ToDoRepository;
import com.todo.test.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository ;



    //FETCH THE LIST

    @Override
    public List<ToDo> getFullList() {
        return toDoRepository.findAll();
    }

    @Override
    public Optional<ToDo> getOneList(@PathVariable long listId) {
        return toDoRepository.findById(listId);
    }

    //ADD TASK THE LIST


    @Override
    public void addList(ToDo todolist) {
        toDoRepository.save(todolist);
       
    }

    @Override
    public List<ToDo> addmultiList(List<ToDo> todolist) {
        toDoRepository.saveAll(todolist);
        return todolist;
    }

    //UPDATE THE LIST

    @Override
    public ToDo updateList(ToDo todolist) {
        toDoRepository.save(todolist);
        return todolist;
    }

    //DELETE THE TASK

    @Override
    public void deleteList(long listId) {
        ToDo t1 = toDoRepository.getOne(listId);
        toDoRepository.delete(t1);

    }



    }

