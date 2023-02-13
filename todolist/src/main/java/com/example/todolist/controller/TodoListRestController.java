package com.example.todolist.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.domain.todo.Todo;
import com.example.todolist.domain.todo.TodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TodoListRestController {

    private final TodoService todoService;

    @PostMapping(value = "/todo/add")
    public Boolean addTodoList(@RequestBody Todo todo){
        try {
            todoService.save(todo);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @PatchMapping(value = "/todo/patch/{idx}")
    public Boolean patchTodoList(@PathVariable("idx") Long idx){
        try {
            Optional<Todo> todo = todoService.findByIdx(idx);
            
            if (todo.isPresent()) {
                Todo findTodo = todo.get();
                
                if (findTodo.getCompleted()) {
                    todoService.notComplete(idx);
                } else {
                    todoService.complete(idx);
                }
            }
        
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    @DeleteMapping(value = "/todo/del/{idx}")
    public Boolean delTodoList(@PathVariable("idx") Long idx){
        try{
            todoService.delete(idx);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
