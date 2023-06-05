package TestApiSave;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;

import static TestApiSave.UrlSender.getResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTest {

    @BeforeEach
    void init(){}

    @Test
    void test() throws FileNotFoundException, JSONException {
        List<String> listUrl = ReaderUrl.readFile("src/test/java/resources/testUrl");
        for (String s : listUrl) {
            UrlSender.TestObj testObj = getResult(s);
            assertEquals(Jsoup.parse(testObj.expected).title(),Jsoup.parse(testObj.valid).title());
        }
    }

}

