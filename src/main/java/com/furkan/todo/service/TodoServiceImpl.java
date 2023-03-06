package com.furkan.todo.service;

import com.furkan.todo.entity.Todo;
import com.furkan.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    TodoRepository todoRepository;

    @Override
    public Todo save(Todo todo) {
        todoRepository.save(todo);
        return todo;
    }

    @Override
    public Todo getById(Long id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Boolean update(Todo todo, Long id) {
        Todo dbTodo = todoRepository.findById(id).orElse(null);
        if (dbTodo != null) {
            dbTodo.setEntry(todo.getEntry());
            dbTodo.setDone(todo.isDone());
            dbTodo.setDate(todo.getDate());
            dbTodo.setPrecedence(todo.getPrecedence());
            todoRepository.save(dbTodo);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
    @Override
    public Boolean updateDone(Todo todo, Long id){
        Todo dbTodo = todoRepository.findById(id).orElse(null);
        if(dbTodo != null){
            dbTodo.setDone(todo.isDone());
            todoRepository.save(dbTodo);
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

}
