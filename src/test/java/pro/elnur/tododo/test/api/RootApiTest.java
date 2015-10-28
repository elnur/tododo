package pro.elnur.tododo.test.api;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.when;

public class RootApiTest extends AbstractApiTest {
    @Test
    public void root() {
        // @formatter:off
        when()
            .get("/")
        .then()
            .statusCode(200)
        ;
        // @formatter:on
    }
}
