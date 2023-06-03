package TestRandom;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class NegativeTest {


    @BeforeEach
    void init() {
        RestAssured.baseURI = "https://randomuser.me/";
    }

    @Test
    public void testSetResults() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?results=-5")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);
        Assertions.assertEquals(post.results.size(),1);
        Assertions.assertEquals(post.info.results,1);
    }

    @Test
    public void testSetGender() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?gender=helecopter")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);
        Assertions.assertEquals(post.results.get(0).gender,"female");
        /**
            тут почему то возвращаеться всегда 1 гендр
         */

    }

    @Test
    public void testSetPassword() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?password=upper,10-8")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        assertTrue(post.results.get(0).login.password.length() >= 8 && post.results.get(0).login.password.length() <= 10);
    }

    @Test
    public void testVersion() {
         given()
            .contentType(ContentType.JSON)
            .when()
            .get("/api/1.0?nat=rs")
            .then()
            .statusCode(200);

        /**
            тут баг в сервисе несоответствие ответа и общей модели json
            отсутствует раздел Street
         */
    }

    @Test
    public void testNoConnect() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);
        Assertions.assertEquals(post.errors,"Uh oh, something has gone wrong. Please tweet us @randomapi about the issue. Thank you.");
    }

    @AfterEach
    void tearDown() {
    }

}
