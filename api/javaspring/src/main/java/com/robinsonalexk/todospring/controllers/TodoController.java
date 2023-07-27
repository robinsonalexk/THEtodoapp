package com.robinsonalexk.todospring.controllers;

import com.robinsonalexk.todospring.models.TodoItem;
import com.robinsonalexk.todospring.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    @GetMapping("")
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        return ResponseEntity.ok(todoService.getAllTodoItems());
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable int id) {
        return ResponseEntity.ok(todoService.getTodoItem(id));
    }

    @GetMapping("{status}")
    public ResponseEntity<List<TodoItem>> getTodoItemById(@PathVariable String status) {
        return ResponseEntity.ok(todoService.getTodoItemByStatus(status));
    }

    @PostMapping("")
    public ResponseEntity addTodoItem(@RequestBody TodoItem request){
        todoService.addTodoItem(request);
        return ResponseEntity.ok(null);
    }

    @PutMapping("")
    public ResponseEntity updateTodoItem(@RequestBody TodoItem request){
        todoService.updateTodoItem((request));
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("")
    public ResponseEntity deleteTodoItem(@PathVariable int id){
        todoService.deleteTodoItem(id);
        return ResponseEntity.ok(null);
    }


}
