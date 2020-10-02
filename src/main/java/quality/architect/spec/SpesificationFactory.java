package quality.architect.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpesificationFactory {

    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification requestSpecification;

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

}
