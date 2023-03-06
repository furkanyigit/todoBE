package com.furkan.todo.service;

import com.furkan.todo.entity.Todo;

import java.util.List;

public interface TodoService {

    //save, getById, getAll, delete, update

    Todo save(Todo todo);

    Todo getById(Long id);

    List<Todo> getAll();

    void deleteById(Long id);

    Boolean update(Todo todo, Long id);

    Boolean updateDone(Todo todo,Long id);
}
