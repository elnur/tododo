package pro.elnur.tododo.test.api;

import java.util.UUID;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pro.elnur.tododo.Application;
import pro.elnur.tododo.model.Task;
import pro.elnur.tododo.repository.TaskRepository;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
@WebAppConfiguration
public class TaskApiTest {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private Flyway flyway;

    @Before
    public void setUp() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("DROP SCHEMA IF EXISTS public CASCADE");
        jdbcTemplate.execute("CREATE SCHEMA public");

        flyway.migrate();
    }

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
            .body("id as UUID", is(task.getId()))
            .body("text", is(task.getText()))
        ;
        // @formatter:on
    }
}
