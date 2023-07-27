package com.robinsonalexk.todospring.services;

import com.robinsonalexk.todospring.models.TodoItem;
import com.robinsonalexk.todospring.repositories.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{
    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
        return todoRepository.findAll();
    }

    @Override
    public TodoItem getTodoItem(int id) {
        return todoRepository.findById(id);
    }

    @Override
    public List<TodoItem> getTodoItemByStatus(String status) {
        return todoRepository.findByStatus(status);
    }

    @Override
    @Transactional
    public void addTodoItem(TodoItem item){
        todoRepository.insert(item);
    }

    @Override
    @Transactional
    public void updateTodoItem(TodoItem item) {
        todoRepository.update(item);
    }

    @Override
    @Transactional
    public void deleteTodoItem(int id) {
        TodoItem itemToRemove = getTodoItem(id);
        todoRepository.delete(itemToRemove);
    }
}
