package quality.architect.request;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestClient {

    public void doPostRequest(String url, String token, Object body, int resCode){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    public void doPostRequest(String url, String token, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doPostRequest(String url, String token, Object body, int resCode, boolean log){
        if (log == true){
            SerenityRest
                    .given()
                    .spec(SpesificationFactory.requestSpecJson(token))
                    .body(body)
                    .when()
                    .post(url)
                    .then()
                    .log()
                    .all()
                    .statusCode(resCode);
        }
    }

    public void doPutRequest(String url, String token, Object body, int resCode){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    public void doPutRequest(String url, String token, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doPutRequest(String url, String token, Object body, int resCode, boolean log){
        if (log == true){
            SerenityRest
                    .given()
                    .spec(SpesificationFactory.requestSpecJson(token))
                    .body(body)
                    .when()
                    .put(url)
                    .then()
                    .log()
                    .all()
                    .statusCode(resCode);
        }
    }

    public void doGetRequest(String url, String token, int resCode){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .get(url)
                .then()
                .statusCode(resCode);
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

    public void doGetRequest(String url, String token, int resCode, boolean log) {
        if (log == true) {
            SerenityRest
                    .given()
                    .spec(SpesificationFactory.requestSpecJson(token))
                    .when()
                    .get(url)
                    .then()
                    .log()
                    .all()
                    .statusCode(resCode);
        }
    }

    public void doDeleteRequest(String url, String token, int resCode){
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .delete(url)
                .then()
                .statusCode(resCode);
    }

    public void doDeleteRequest(String url, String token, int resCode, String pathJsonSchema) {
        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .delete(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doDeleteRequest(String url, String token, int resCode, boolean log) {
        if (log == true) {
            SerenityRest
                    .given()
                    .spec(SpesificationFactory.requestSpecJson(token))
                    .when()
                    .delete(url)
                    .then()
                    .log()
                    .all()
                    .statusCode(resCode);
        }
    }

}
