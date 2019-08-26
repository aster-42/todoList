package com.axe.todo.controller;

import com.axe.todo.entity.Todo;
import com.axe.todo.entity.TodoEnum;
import com.axe.todo.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoService {

    @Autowired
    public void setRepository(TodoRepository repository) {
        this.repository = repository;
    }

    private TodoRepository repository;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("list", repository.findAll());
        return mv;
    }

    @RequestMapping("/list")
    public Object listAll() {
        return repository.findAll();
    }

    @RequestMapping("/add")
    public String add(String content) {
        repository.save(new Todo(TodoEnum.StatusTodo.getStatus(), content));
        return "redirect:/";
    }

    @RequestMapping("/modify/{id}/{status}")
    public String modify(@PathVariable Long id, @PathVariable Integer status) {
        repository.updateById(id, status);
        return "redirect:/";
    }
}
