import org.junit.BeforeClass;
import org.junit.Test;
import quality.architect.request.RestClient;

import java.util.HashMap;
import java.util.Map;

public class RestClientTest {

    RestClient restClient = new RestClient();

    @BeforeClass
    public static void setUrl(){
        String Url = "https://reqres.in";
    }

    @Test
    public void testPost(){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("username", "kraken");
        jsonAsMap.put("password", "kraken");

//        restClient.getToken("/api/login", jsonAsMap, "token");
        restClient.doPostRequest("/api/login", jsonAsMap, 200);
    }

}
