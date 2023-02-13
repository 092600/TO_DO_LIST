package com.example.todolist.domain.todo;

import java.util.List;
import java.util.Optional;

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
    

    public void delete(Long idx) {
        Optional<Todo> todo = todoRepository.findById(idx);

        if (todo.isPresent()) {
            todoRepository.deleteById(idx);
        }
    
    }



    public Optional<Todo> findByIdx(Long idx) {
        return todoRepository.findById(idx);
    }
    
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }


    public List<Todo> findAllByCreatedDate(String createdDate) {
        return todoRepository.findAllByCreatedDate(createdDate);
    }
}

