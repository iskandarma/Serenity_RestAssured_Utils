package quality.architect.request;

import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestClient {

    SpesificationFactory spesificationFactory = new SpesificationFactory();

    public void doPostRequest(String url, String token, Object body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    public void doPostRequest(String url, String token, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doPostXmlRequest(String url, String token, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doPostXmlRequest(String url, String username, String password, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
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
                    .spec(spesificationFactory.requestSpecJson(token))
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
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    public void doPutRequest(String url, String token, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doPutXmlRequest(String url, String token, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
    }

    public void doPutXmlRequest(String url, String username, String password, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
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
                    .spec(spesificationFactory.requestSpecJson(token))
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
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .get(url)
                .then()
                .statusCode(resCode);
    }

    public void doGetRequest(String url, String token, int resCode, String pathJsonSchema) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
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
                    .spec(spesificationFactory.requestSpecJson(token))
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
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .delete(url)
                .then()
                .statusCode(resCode);
    }

    public void doDeleteRequest(String url, String token, int resCode, String pathJsonSchema) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
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
                    .spec(spesificationFactory.requestSpecJson(token))
                    .when()
                    .delete(url)
                    .then()
                    .log()
                    .all()
                    .statusCode(resCode);
        }
    }

    public String getToken(String url, Object body, String tokenPath) {
        String token =  SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson())
                .body(body)
                .when()
                .post(url)
                .then()
                .extract()
                .path(tokenPath);
        return token;
    }

}
