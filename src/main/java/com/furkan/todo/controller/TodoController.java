package com.furkan.todo.controller;

import com.furkan.todo.entity.Todo;
import com.furkan.todo.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    TodoServiceImpl todoService;

    @GetMapping("/get-all")
    public List<Todo> getTodos(){
        return todoService.getAll();
    }
    @PostMapping("/create")
    public ResponseEntity<Todo> create(@RequestBody Todo newTodo) {
        Todo todo = todoService.save(newTodo);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    //TODO: ResponseEntity niye yazdık, yazamasak ne oluyor? Yazdigimizda ne artisi var.
    @PutMapping("/update/{id}")
    public Boolean update(@RequestBody Todo newTodo,@PathVariable Long id){
        return todoService.update(newTodo, id);
    }
    @PutMapping("/updateDone/{id}")
    public Boolean updateDone(@RequestBody Todo newTodo,@PathVariable Long id){
        return todoService.updateDone(newTodo, id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        todoService.deleteById(id);
    }
}
