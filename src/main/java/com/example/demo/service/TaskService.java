package com.example.demo.service;

import com.example.demo.dao.TaskRepository;
import com.example.demo.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        for(Task task : taskRepository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

}
