package quality.architect.request;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestMethod {

    SpesificationFactory spesificationFactory;

    public RestMethod(){
        spesificationFactory = new SpesificationFactory();
    }

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

    public void doPostFormDataRequest(String url, String token, Map<String,Object> body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token))
                .params(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    public void doPostRequest(String url, Object body, int resCode){
        SerenityRest
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    public void doPostRequest(String url, String username, String password, Object body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    public void doPostFormDataRequest(String url, String username, String password, Map<String,Object> body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
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

    public void doPostRequest(String url, String username, String password, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
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

    public void doPostXmlRequest(String url, String username, String password, Object body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
                .body(body)
                .when()
                .post(url)
                .then()
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

    public void doPutRequest(String url, String username, String password, Object body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
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

    public void doPutRequest(String url, String username, String password, Object body, int resCode, String pathJsonSchema){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
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

    public void doPutXmlRequest(String url, String username, String password, Object body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
                .body(body)
                .when()
                .put(url)
                .then()
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

    public void doPutFormDataRequest(String url, String username, String password, Map<String,Object> body, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
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

    public void doGetRequest(String url, String username, String password, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .get(url)
                .then()
                .statusCode(resCode);
    }

    public void doGetRequest(String url, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson())
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

    public void doGetRequest(String url, String username, String password, int resCode, String pathJsonSchema) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .get(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
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

    public void doDeleteRequest(String url, String username, String password, int resCode){
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
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

    public void doDeleteRequest(String url, String username, String password, int resCode, String pathJsonSchema) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .delete(url)
                .then()
                .body(matchesJsonSchemaInClasspath(pathJsonSchema))
                .statusCode(resCode);
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
