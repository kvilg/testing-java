package TestRandom;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

public class PositiveTest {


    @BeforeEach
    void init() {
        RestAssured.baseURI = "https://randomuser.me/";
    }

    @Test
    public void testSetResults() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api?results=10")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        Assertions.assertEquals(post.info.results,10);
        Assertions.assertEquals(post.results.size(),10);
    }

    @Test
    public void testSetGender() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?gender=female")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);
        Assertions.assertEquals(post.results.get(0).gender,"female");
    }

    @Test
    public void testSetPassword() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?password=upper,2-2")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        Assertions.assertEquals(post.results.get(0).login.password.length(),2);
    }

    @Test
    public void testSetSeed() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?seed=see")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        Assertions.assertEquals(post.info.seed,"see");
    }

    @Test
    public void testSetNat() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/?nat=gb")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        Assertions.assertEquals(post.results.get(0).nat,"GB");
    }


    @Test
    public void testFull() {
        Post post = given()
                .contentType(ContentType.XML)
                .when()
                .get("/api/?results=10&seed=foobar&gender=female&password=number,2-8")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        Assertions.assertEquals(post.results.size(),10);
        Assertions.assertEquals(post.info.results,10);
        Assertions.assertEquals(post.info.seed,"foobar");

        post.results.parallelStream().peek(m->{
            Assertions.assertEquals(m.gender,"famale");
            assertTrue(StringUtils.isNumeric(m.login.password));
            assertTrue( m.login.password.length() >= 2 && m.login.password.length() <= 8);
        });
    }

    @Test
    public void testVersion() {
        Post post = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/1.4?nat=rs")
                .then()
                .statusCode(200)
                .extract()
                .as(Post.class);

        Assertions.assertEquals(post.results.get(0).nat,"RS");
    }



    @AfterEach
    void tearDown() {
    }

}
