package pro.elnur.tododo.test.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pro.elnur.tododo.Application;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@IntegrationTest
@WebAppConfiguration
public class HomeApiTest {
    @Test
    public void home() {
        // @formatter:off
        when()
            .get("/")
        .then()
            .statusCode(200)
        ;
        // @formatter:on
    }
}
