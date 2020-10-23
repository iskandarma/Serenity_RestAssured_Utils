package quality.architect.spec;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;
import java.util.regex.Pattern;

public class SpesificationFactory {

    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification requestSpecification;
    private PreemptiveBasicAuthScheme preemptiveBasicAuthScheme;

    public RequestSpecification requestSpecJson(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecJson(String token){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer "+token);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecJson(String username, String password){
        preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
        preemptiveBasicAuthScheme.setUserName(username);
        preemptiveBasicAuthScheme.setPassword(password);

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAuth(preemptiveBasicAuthScheme);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecXml(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.XML);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecXml(String token){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.XML);
        requestSpecBuilder.addHeader("Authorization", "Bearer "+token);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecXml(String username, String password){
        preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
        preemptiveBasicAuthScheme.setUserName(username);
        preemptiveBasicAuthScheme.setPassword(password);

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setAuth(preemptiveBasicAuthScheme);
        requestSpecBuilder.setContentType(ContentType.XML);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecFormData(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setUrlEncodingEnabled(true);
        requestSpecBuilder.setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)));
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecFormData(String token){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setUrlEncodingEnabled(true);
        requestSpecBuilder.setConfig(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)));
        requestSpecBuilder.addHeader("Authorization", "Bearer "+token);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecFormData(String username, String password, Map<String,Object> body){

        preemptiveBasicAuthScheme = new PreemptiveBasicAuthScheme();
        preemptiveBasicAuthScheme.setUserName(username);
        preemptiveBasicAuthScheme.setPassword(password);

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType("multipart/form-data");
        requestSpecBuilder.setAuth(preemptiveBasicAuthScheme);
        for (Map.Entry<String,Object> entry : body.entrySet())
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value.toString().contains("/") && value.toString().contains(".")){
                requestSpecBuilder.addMultiPart(key, (File) value);
            } else {
                requestSpecBuilder.addMultiPart(key, (String) value);
            }
        }
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public RequestSpecification requestSpecFormData(String token, Map<String,Object> body){

        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.addHeader("Authorization", "Bearer "+token);
        requestSpecBuilder.setContentType("multipart/form-data");
        requestSpecBuilder.setAuth(preemptiveBasicAuthScheme);
        for (Map.Entry<String,Object> entry : body.entrySet())
        {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value.toString().contains("/") && value.toString().contains(".")){
                requestSpecBuilder.addMultiPart(key, (File) value);
            } else {
                requestSpecBuilder.addMultiPart(key, (String) value);
            }
        }
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

}
