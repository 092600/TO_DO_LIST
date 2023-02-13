package com.example.todolist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.todolist.domain.todo.TodoService;


import org.springframework.ui.Model;

@Controller
public class TodoListController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/")
    public String getTodoList(Model model){
        model.addAttribute("todolist", todoService.findAll());

        return "todolist";
    }

    @DeleteMapping(value = "/todo/{idx}")
    public String delTodo(@PathVariable("idx") Long idx){
        todoService.delete(idx);

        return "redirect:/";
    }

    @GetMapping(value = "/todo/add")
    public String addTodoListPage() {
        return "createTodoListPage";
    }

    @GetMapping(value = "/todo/search/{searchDatetime}")
    public String searchTodos(@PathVariable("searchDatetime") String searchDatetime,
                                Model model){
        model.addAttribute("todolist", todoService.findAllByCreatedDate(searchDatetime));
        model.addAttribute("searchDatetime", searchDatetime);

        return "todolist";

    }

}
