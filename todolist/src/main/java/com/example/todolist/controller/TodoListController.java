package com.example.todolist.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.todolist.domain.todo.Todo;
import com.example.todolist.domain.todo.TodoService;


import org.springframework.ui.Model;

@Controller
public class TodoListController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/")
    public String getToDoList(Model model){
        model.addAttribute("todoList", todoService.findAll());

        return "test";
    }

    @PostMapping(value = "/todo")
    public String addToDoList(@RequestBody Todo todo){
        todoService.save(todo);
        
        return "test";
    }

    @DeleteMapping(value = "/todo/{idx}")
    public String delToDo(@PathParam("idx") Long idx){
        todoService.delete(idx);

        return "test";
    }


}
