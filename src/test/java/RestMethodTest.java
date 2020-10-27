import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import quality.architect.request.Request;
import quality.architect.request.RestMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class RestMethodTest {

    private Request request;
    private String baseUrl;
    private final String SECURED_TEST_HEADER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiQWRtaW4iLCJpZCI6IjEyMyJ9.AqKRNmhFn3xyl7lvtt1pCsvj8OfIh5RpzmKeCZpdEbI";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(8089).notifier(new ConsoleNotifier(true)).extensions("com.github.masonm.JwtMatcherExtension", "com.github.masonm.JwtStubMappingTransformer")); // No-args constructor defaults

    @Before
    public void before(){
        request = new RestMethod();
        baseUrl = "http://localhost:8089";
    }

    @Test
    public void jwtToken() {

        Map<String, Object> jsonWireMock = new HashMap<>();
        jsonWireMock.put("header", new HashMap<String, String>(){{
            put("alg","HS256");
            put("typ", "JWT");
        }});
        jsonWireMock.put("payload", new HashMap<String, String>(){{
            put("name","Admin");
            put("id", "123" );
        }});
        jsonWireMock.put("request", new HashMap<String, Object>(){{
            put("url","/jwt");
            put("method","ANY");
        }});

        stubFor(requestMatching("jwt-matcher",Parameters.from(jsonWireMock))
                .willReturn(okJson("{ \"message\": \"Hello\" }")));

        request.get(baseUrl+"/jwt",SECURED_TEST_HEADER,200);
        request.get(baseUrl+"/jwt",SECURED_TEST_HEADER,200,"JSONSchema/response.json");
        request.delete(baseUrl+"/jwt", SECURED_TEST_HEADER, 200);
        request.delete(baseUrl+"/jwt", SECURED_TEST_HEADER, 200,"JSONSchema/response.json");
        request.patch(baseUrl+"/jwt",SECURED_TEST_HEADER,200);
        request.patch(baseUrl+"/jwt",SECURED_TEST_HEADER,200,"JSONSchema/response.json");
    }

    @Test
    public void jwtTokenWithJsonBodyReq() {

        Map<String, Object> jsonWireMock = new HashMap<>();
        jsonWireMock.put("header", new HashMap<String, String>(){{
            put("alg","HS256");
            put("typ", "JWT");
        }});
        jsonWireMock.put("payload", new HashMap<String, String>(){{
            put("name","Admin");
            put("id", "123" );
        }});
        jsonWireMock.put("request", new HashMap<String, Object>(){{
            put("url","/jwtwithbody");
            put("method","ANY");
            put("bodyPatterns", new Object[] {new HashMap<String,Object>(){{
                put("equalToJson", new HashMap<String,Object>(){{
                    put("key1","value1");
                }});
            }}});
        }});

        stubFor(requestMatching("jwt-matcher",Parameters.from(jsonWireMock))
                .willReturn(okJson("{ \"message\": \"Hello\" }")));

        Map<String, Object> bodyJson = new HashMap<>();
        bodyJson.put("key1", "value1");

        request.post(baseUrl+"/jwtwithbody",SECURED_TEST_HEADER, bodyJson,200);
        request.post(baseUrl+"/jwtwithbody",SECURED_TEST_HEADER, bodyJson,200,"JSONSchema/response.json");
        request.put(baseUrl+"/jwtwithbody", SECURED_TEST_HEADER, bodyJson, 200);
        request.put(baseUrl+"/jwtwithbody", SECURED_TEST_HEADER, bodyJson, 200,"JSONSchema/response.json");
        request.patch(baseUrl+"/jwtwithbody", SECURED_TEST_HEADER, bodyJson, 200);
        request.patch(baseUrl+"/jwtwithbody", SECURED_TEST_HEADER, bodyJson, 200,"JSONSchema/response.json");
    }

    @Test
    public void basicAuth() {

        givenThat(any(urlPathEqualTo("/basic"))
                .withBasicAuth("test", "123")
                .willReturn(okJson("{ \"message\": \"Hello\" }")));

        request.get(baseUrl+"/basic", "test", "123", 200);
        request.get(baseUrl+"/basic", "test", "123", 200, "JSONSchema/response.json");
        request.delete(baseUrl+"/basic", "test", "123", 200);
        request.delete(baseUrl+"/basic", "test", "123", 200, "JSONSchema/response.json");
        request.patch(baseUrl+"/basic", "test", "123", 200);
        request.patch(baseUrl+"/basic", "test", "123", 200,"JSONSchema/response.json");
    }

    @Test
    public void basicAuthWithJsonBodyReq() {

        givenThat(any(urlPathEqualTo("/basic/withjsonbody"))
                .withBasicAuth("test", "123")
                .withRequestBody(equalToJson("{\"username\" : \"test\", \"password\" : \"123\"}"))
                .willReturn(okJson("{ \"message\": \"Hello\" }")));

        Map<String, Object> bodyJson = new HashMap<>();
        bodyJson.put("username", "test");
        bodyJson.put("password", "123");

        request.post(baseUrl+"/basic/withjsonbody","test", "123", bodyJson, 200);
        request.post(baseUrl+"/basic/withjsonbody","test", "123", bodyJson, 200, "JSONSchema/response.json");
        request.put(baseUrl+"/basic/withjsonbody", "test", "123", bodyJson, 200);
        request.put(baseUrl+"/basic/withjsonbody", "test", "123", bodyJson, 200, "JSONSchema/response.json");
        request.patch(baseUrl+"/basic/withjsonbody", "test", "123", bodyJson, 200);
        request.patch(baseUrl+"/basic/withjsonbody", "test", "123", bodyJson, 200, "JSONSchema/response.json");
    }

    @Test
    public void jwtTokenWithMultiPartReqBody(){

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
                .willReturn(okJson("{ \"message\": \"Hello\" }")));

        Map<String, Object> bodyFormData = new HashMap<>();
        bodyFormData.put("username", "test");
        bodyFormData.put("password", "123");
        bodyFormData.put("file", new File("src/test/resources/abc.txt"));

        request.postMultipart(baseUrl+"/basic/withformdatabody", "test", "123", bodyFormData, 200);
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

        request.postXml(baseUrl+"/basic/withxmlbody","test", "123", req, 200);
        request.putXml(baseUrl+"/basic/withxmlbody", "test", "123", req, 200);
    }

    @Test
    public void basicAuthWithMultiPartReqBody(){

        givenThat(any(urlPathEqualTo("/basic/withformdatabody"))
                .withBasicAuth("test","123")
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

        Map<String, Object> bodyFormData = new HashMap<>();
        bodyFormData.put("username", "test");
        bodyFormData.put("password", "123");
        bodyFormData.put("file", new File("src/test/resources/abc.txt"));

        request.postMultipart(baseUrl+"/basic/withformdatabody", "test", "123", bodyFormData, 200);
        request.putMultipart(baseUrl+"/basic/withformdatabody", "test", "123", bodyFormData, 200);
    }

}
