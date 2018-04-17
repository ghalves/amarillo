package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

     @GetMapping("/tasks")
     public String tasks(HttpServletRequest request) {
        request.setAttribute("tasks", taskService.findAll());
        return "tasks";
     }

     @GetMapping("/new-task")
    public String newTask() {
        return "new-task";
     }

     @PostMapping("/new-task")
    public String newTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
        task.setDate_created(new Date());
         taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        return "tasks";
     }

     @GetMapping("/update-task")
    public String updateTask(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("task", taskService.findById(id).get());
        return "update-task";
     }

    @PostMapping("/update-task")
    public String updateTask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
        task.setDate_created(new Date());
        taskService.save(task);
        request.setAttribute("tasks", taskService.findAll());
        return "tasks";
    }

     @GetMapping("/delete-task")
    public String deleteTask(@RequestParam int id, HttpServletRequest request) {
         taskService.deleteById(id);
         request.setAttribute("tasks", taskService.findAll());
         return "tasks";
     }

}
