package quality.architect.request;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;

public class RestClient {

    public Response doGetRequest(String path){
        return SerenityRest
                .given()
                .when()
                .get(path);
    }

    public Response doGetRequest(String path, String token){
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .get(path);
    }

    public Response doPostRequest(String path, Object body){
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson())
                .body(body)
                .when()
                .post(path);
    }

    public Response doPostRequest(String path, Object body, String token){
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(path);
    }

    public Response doPutRequest(String path, Object body){
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson())
                .body(body)
                .when()
                .put(path);
    }

    public Response doPutRequest(String path, Object body, String token){
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(path);
    }

    public Response doDeleteRequest(String path){
        return SerenityRest
                .given()
                .when()
                .delete(path);
    }

    public Response doDeleteRequest(String path, String token){
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .delete(path);
    }

}
