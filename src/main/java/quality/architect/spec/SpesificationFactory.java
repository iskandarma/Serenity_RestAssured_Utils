package quality.architect.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpesificationFactory {

    private static RequestSpecBuilder requestSpecBuilder;
    private static RequestSpecification requestSpecification;

    public static synchronized RequestSpecification requestSpecJson(){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }

    public static synchronized RequestSpecification requestSpecJson(String token){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.addHeader("Authorization", "Bearer "+token);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }
}
