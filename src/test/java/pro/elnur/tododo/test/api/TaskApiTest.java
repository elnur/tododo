package pro.elnur.tododo.test.api;

import java.util.UUID;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pro.elnur.tododo.model.Task;
import pro.elnur.tododo.repository.TaskRepository;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class TaskApiTest extends AbstractApiTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void view() {
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setText("My first task");

        taskRepository.save(task);

        // @formatter:off
        when()
            .get("/tasks/{id}", task.getId())
        .then()
            .statusCode(200)
            .body("size()", is(2))
            .body("id", is(task.getId().toString()))
            .body("text", is(task.getText()))
        ;
        // @formatter:on
    }
}
