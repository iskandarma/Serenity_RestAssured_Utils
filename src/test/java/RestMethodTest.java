import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import quality.architect.request.RestMethod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertTrue;

public class RestMethodTest {

    private RestMethod restMethod;
    private String baseUrl;
    private final String SECURED_TEST_HEADER = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiQWRtaW4iLCJpZCI6IjEyMyJ9.AqKRNmhFn3xyl7lvtt1pCsvj8OfIh5RpzmKeCZpdEbI";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(WireMockConfiguration.options().port(8089).notifier(new ConsoleNotifier(true)).extensions("com.github.masonm.JwtMatcherExtension", "com.github.masonm.JwtStubMappingTransformer")); // No-args constructor defaults

    @Before
    public void before(){
        restMethod = new RestMethod();
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
                .willReturn(aResponse().withStatus(200)));

//        restMethod.doGetRequest(baseUrl+"/jwt",SECURED_TEST_HEADER,200);
//        restMethod.doDeleteRequest(baseUrl+"/jwt", SECURED_TEST_HEADER, 200);
    }

    @Test
    public void jwtTokenWithReqBodyJson() {

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
                .willReturn(aResponse().withStatus(200)));

        Map<String, Object> bodyJson = new HashMap<>();
        bodyJson.put("key1", "value1");

//        restMethod.doPostRequest(baseUrl+"/jwtwithbody",SECURED_TEST_HEADER, bodyJson,200);
//        restMethod.doPutRequest(baseUrl+"/jwtwithbody", SECURED_TEST_HEADER, bodyJson, 200);
    }

    @Test
    public void jwtTokenWithMultiPartReqBody(){

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

    @Test
    public void basicAuth() {

        givenThat(any(urlPathEqualTo("/basic"))
                .withBasicAuth("test", "123")
                .willReturn(aResponse()
                    .withStatus(200)
                    .withHeader("Content-Type", "application/json")));

//        restMethod.doGetRequest(baseUrl+"/basic", "test", "123", 200);
//        restMethod.doDeleteRequest(baseUrl+"/basic", "test", "123", 200);
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

//        restMethod.doPostRequest(baseUrl+"/basic/withjsonbody","test", "123", bodyJson, 200);
//        restMethod.doPutRequest(baseUrl+"/basic/withjsonbody", "test", "123", bodyJson, 200);
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

//        restMethod.doPostXmlRequest(baseUrl+"/basic/withxmlbody","test", "123", req, 200);
//        restMethod.doPutXmlRequest(baseUrl+"/basic/withxmlbody", "test", "123", req, 200);
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

//        restMethod.doPostFormDataRequest(baseUrl+"/basic/withformdatabody", "test", "123", bodyFormData, 200);
//        restMethod.doPutFormDataRequest(baseUrl+"/basic/withformdatabody", "test", "123", bodyFormData, 200);
    }

}
