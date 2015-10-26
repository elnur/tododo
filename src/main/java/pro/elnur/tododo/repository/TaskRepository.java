package pro.elnur.tododo.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Component;
import pro.elnur.tododo.model.Task;

@Component
public class TaskRepository {
    private Map<UUID, Task> tasks = new HashMap<>();

    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task findOne(UUID id) {
        return tasks.get(id);
    }
}
