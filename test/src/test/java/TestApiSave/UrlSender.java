package TestApiSave;

import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class UrlSender {

    static public TestObj getResult(String url) throws JSONException {

        ResultUrl post = sendService(url);

        String expected = given()
                .get(url)
                .asString();

        String valid = given()
                .header("User-Agent","kv")
                .header("Accept","*/*")
                .get(post.result_url)
                .asString();

        return new TestObj(expected,valid);
    }

    public static ResultUrl sendService(String url) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("url", url);

        return given()
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .as(ResultUrl.class);
    }

    static class TestObj{
        public String expected;
        public String valid;

        public TestObj(String expected, String valid) {
            this.expected = expected;
            this.valid = valid;
        }
    }
    static class ResultUrl{
        public String result_url;
        public String error;
    }
}
