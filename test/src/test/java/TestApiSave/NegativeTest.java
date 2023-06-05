package TestApiSave;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import static TestApiSave.UrlSender.sendService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeTest {

    @Test
    void test() throws JSONException {
        assertEquals(sendService("ss").error,"API Error: URL is invalid (check #1)");
    }

}
