package com.robinsonalexk.todospring.repositories;

import com.robinsonalexk.todospring.models.TodoItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepositoryImpl implements TodoRepository{

    private EntityManager entityManager;

    @Autowired
    public TodoRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public TodoItem findById(int id) {
        return entityManager.find(TodoItem.class, id);
    }

    @Override
    public List<TodoItem> findByStatus(String status){
        TypedQuery<TodoItem> query = entityManager.createQuery("FROM TodoItem WHERE status=:val ", TodoItem.class);
        query.setParameter("val", status);
        return query.getResultList();
    }

    @Override
    public List<TodoItem> findAll(){
        TypedQuery<TodoItem> query = entityManager.createQuery("FROM TodoItem", TodoItem.class);
        return query.getResultList();
    }

    @Override
    public void insert(TodoItem item){
        entityManager.persist(item);
    }

    @Override
    public void update(TodoItem item) {
        entityManager.merge(item);
    }

    @Override
    public void delete(TodoItem item){
        entityManager.remove(item);
    }


}
