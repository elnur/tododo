package pro.elnur.tododo.repository;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import pro.elnur.tododo.model.Task;

public interface FooTaskRepository extends CrudRepository<Task, UUID> {
}
