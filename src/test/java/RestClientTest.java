import com.github.tomakehurst.wiremock.junit.WireMockRule;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import quality.architect.request.RestClient;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RestClientTest {

    private RestClient restClient;
    private String baseUrl;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089); // No-args constructor defaults

    @Before
    public void before(){
        restClient = new RestClient();
        baseUrl = "http://localhost:8089";
    }

    @Test
    public void basicAuth() {

        givenThat(any(urlPathEqualTo("/basic"))
                .withBasicAuth("test", "123")
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")));

        restClient.doGetRequest(baseUrl+"/basic", "test", "123", 200);
        restClient.doDeleteRequest(baseUrl+"/basic", "test", "123", 200);
    }

    @Test
    public void basicAuthWithJsonBodyReq() {

        givenThat(any(urlPathEqualTo("/basic/withjsonbody"))
                .withBasicAuth("test", "123")
                .withRequestBody(equalToJson("{\"username\" : \"test\", \"password\" : \"123\"}"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")));

        Map<String, Object> bodyJson = new HashMap<>();
        bodyJson.put("username", "test");
        bodyJson.put("password", "123");

        restClient.doPostRequest(baseUrl+"/basic/withjsonbody","test", "123", bodyJson, 200);
        restClient.doPutRequest(baseUrl+"/basic/withjsonbody", "test", "123", bodyJson, 200);
    }

    @Test
    public void basicAuthWithXmlBodyReq() {

        String req = "<?xml version=\"1.0\"?>\n" +
                "<soap:Envelope\n" +
                "xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope/\"\n" +
                "soap:encodingStyle=\"http://www.w3.org/2003/05/soap-encoding\">\n" +
                "<soap:Body>\n" +
                "  <m:GetPrice xmlns:m=\"https://www.w3schools.com/prices\">\n" +
                "    <m:Item>Apples</m:Item>\n" +
                "  </m:GetPrice>\n" +
                "</soap:Body>\n" +
                "</soap:Envelope> ";

        givenThat(any(urlPathEqualTo("/basic/withxmlbody"))
                .withBasicAuth("test", "123")
                .withHeader("Content-Type", containing("xml"))
                .withRequestBody(equalToXml(req))
                .willReturn(aResponse()
                        .withStatus(200)));

        restClient.doPostXmlRequest(baseUrl+"/basic/withxmlbody","test", "123", req, 200);
        restClient.doPutXmlRequest(baseUrl+"/basic/withxmlbody", "test", "123", req, 200);
    }

    @Test
    public void basicAuthWithMultiPartBodyReq(){

        Map<String, Object> bodyFormData = new HashMap<>();
        bodyFormData.put("username", "test");
        bodyFormData.put("password", "123");

        givenThat(post(urlPathEqualTo("/basic/withformdatabody"))
                .withMultipartRequestBody(aMultipart()
                    .withName("username")
                    .withBody(containing("test")))
                .withMultipartRequestBody(aMultipart()
                    .withName("password")
                    .withBody(containing("123")))
                .withMultipartRequestBody(aMultipart()
                    .withName("file")
                    .withBody(binaryEqualTo("ABCD".getBytes())))
                .willReturn(aResponse()
                    .withStatus(200)));

        SerenityRest
                .given()
                .multiPart("username", "test")
                .multiPart("password", "123")
                .multiPart("file", new File("src/test/resources/abc.txt"))
                .when()
                .post(baseUrl+"/basic/withformdatabody")
                .then()
                .statusCode(200);

//        restClient.doPostFormDataRequest(baseUrl+"/basic/withformdatabody", "test", "123", bodyFormData, 200);
    }

}
