package pro.elnur.tododo.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.elnur.tododo.model.Task;
import pro.elnur.tododo.repository.TaskRepository;

@RestController
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping("/tasks/{id}")
    public Task view(@PathVariable UUID id) {
        return taskRepository.findOne(id);
    }
}
