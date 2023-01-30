package com.example.todolist.domain.todo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    public void complete(Long idx) {
        todoRepository.updateCompleted(true, idx);
    }

    public void notComplete(Long idx) {
        todoRepository.updateCompleted(false, idx);
    }
    

    public void update(Todo todo) {
        todoRepository.updateTodoCategorytAndContent(todo.getCategory(), todo.getContent(), todo.getIdx());
    }

    public void delete(Long idx) {
        Todo todo = findByIdx(idx);
        todoRepository.delete(todo);
    }



    public Todo findByIdx(Long idx) {
        return todoRepository.findByIdx(idx);
    }
    
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }


    public List<Todo> findAllByCreatedDate(String createdDate) {
        return todoRepository.findAllByCreatedDate(createdDate);
    }
}

