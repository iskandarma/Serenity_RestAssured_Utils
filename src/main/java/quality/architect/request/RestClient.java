package quality.architect.request;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;
import java.util.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestClient {

    public void doGetRequest(String url, String token, int resCode){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .get(url)
                .then()
                .statusCode(resCode);
    }

    public void doGetRequest(String url, String token, int resCode, boolean log) {
        if (log == true) {
            SerenityRest
                    .given()
                    .spec(SpesificationFactory.requestSpecJson(token))
                    .when()
                    .get(url)
                    .then()
                    .statusCode(resCode);
        }
    }

    public void doGetRequest(String url, String token, int resCode, String pathJsonSchema) {
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .get(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
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
