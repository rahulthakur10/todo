package com.todo.test.ToDoController;


import com.todo.test.ToDoService.ToDoService;
import com.todo.test.entities.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController							
public class ToDoController {

    @Autowired
    private ToDoService toDoService ;


    @RequestMapping("/homelist")
    public String home(){
        return "ADD TASK TO LIST";
    }

    @GetMapping("/getfulllist")
    public List<ToDo> getFullList() {
        return this.toDoService.getFullList();
    }

    @GetMapping("/getTodoList/{listId}")
    public Optional<ToDo> getOneList(@PathVariable("listId") long listId) {
        return (Optional<ToDo>) this.toDoService.getOneList(listId);
    }

    @PostMapping("/savelist")
    public void addList(@RequestBody ToDo todolist) {
       this.toDoService.addList(todolist);
    }

    @PostMapping("/savemultilist")
    public List<ToDo> addmultiList(@RequestBody List<ToDo> todolist) {
        return this.toDoService.addmultiList(todolist);
    }

    @PutMapping("/updatelist/")
    public ToDo updateList(@RequestBody ToDo todolist) {
        return this.toDoService.updateList(todolist);
    }


    @DeleteMapping("deletelist/{listId}")
    public ResponseEntity<HttpStatus> deleteList(@PathVariable String listId) {

        try
        {
            this.toDoService.deleteList(Long.parseLong(listId));
            return new ResponseEntity<>(HttpStatus.OK);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
