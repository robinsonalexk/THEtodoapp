package com.robinsonalexk.todospring.repositories;

import com.robinsonalexk.todospring.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TodoRepository {

    TodoItem findById(int id);
    List<TodoItem> findByStatus(String status);
    List<TodoItem> findAll();
    void insert(TodoItem item);
    void update(TodoItem item);
    void delete(TodoItem item);

}
