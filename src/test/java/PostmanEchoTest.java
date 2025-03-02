import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .log().all()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostRequestRawText() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "This is a raw text request";

        given()
                .log().all()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo(requestBody));
    }

    @Test
    public void testPostRequestFormData() {
        RestAssured.baseURI = "https://postman-echo.com";

        given()
                .log().all()
                .contentType(ContentType.MULTIPART)
                .multiPart("key1", "value1")
                .multiPart("key2", "value2")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.key1", equalTo("value1"))
                .body("form.key2", equalTo("value2"));
    }

    @Test
    public void testPutRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"key\": \"value\"}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.key", equalTo("value"));
    }

    @Test
    public void testPatchRequest() {
        RestAssured.baseURI = "https://postman-echo.com";

        String requestBody = "{\"key\": \"value\"}";

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("json.key", equalTo("value"));
    }
}