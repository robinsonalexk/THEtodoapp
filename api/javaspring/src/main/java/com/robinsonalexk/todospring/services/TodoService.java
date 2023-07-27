package com.robinsonalexk.todospring.services;

import com.robinsonalexk.todospring.models.TodoItem;

import java.util.List;

public interface TodoService {
    List<TodoItem> getAllTodoItems();
    TodoItem getTodoItem(int id);
    List<TodoItem> getTodoItemByStatus(String status);
    void addTodoItem(TodoItem item);
    void updateTodoItem(TodoItem item);
    void deleteTodoItem(int id);
}
