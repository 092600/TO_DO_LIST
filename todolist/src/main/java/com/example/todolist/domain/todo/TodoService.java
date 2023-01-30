package com.example.todolist.domain.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    public void complete(Todo todo) {
        todoRepository.updateCompleted(true, todo.getIdx());
    }
    

    public void update(Todo todo) {
        todoRepository.updateTodoCategorytAndContent(todo.getCategory(), todo.getContent(), todo.getIdx());
    }

    public void delete(Long idx) {
        todoRepository.deleteById(idx);
    }


    
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}

