import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import quality.architect.request.RestClient;

import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RestClientTest {

    private RestClient restClient;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults

    @Before
    public void before(){
        restClient = new RestClient();
    }

    @Test
    public void basicAuth() {

        givenThat(any(urlPathEqualTo("/everything"))
                .withBasicAuth("test", "123")
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")));

        restClient.doGetRequest("http://localhost:8089/everything", "sdad", 200);
        restClient.doDeleteRequest("http://localhost:8089/everything", "sdsada", 200);
    }

    @Test
    public void testPost(){
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("username", "kraken");
        jsonAsMap.put("password", "kraken");

//        restClient.getToken("/api/login", jsonAsMap, "token");
        restClient.doPostRequest("/api/login", jsonAsMap, 200);
    }

    @Test
    public void testMultipart(){
        givenThat(any(urlPathEqualTo("/everything"))
                .withBasicAuth("test", "123")
                .withMultipartRequestBody(
                        aMultipart()
                                .withName("info")
                                .withHeader("Content-Type", containing("charset"))
                                .withBody(equalToJson("{}"))
                )
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")));
    }

}
