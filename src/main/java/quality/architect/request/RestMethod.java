package quality.architect.request;

import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class RestMethod implements Request{

    SpesificationFactory spesificationFactory;

    public RestMethod(){
        spesificationFactory = new SpesificationFactory();
    }

    @Override
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

    @Override
    public void post(String url, String token, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void post(String url, String token, Object body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void post(String url, String username, String password, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void post(String url, String username, String password, Object body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void postXml(String url, String token, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(token))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void postXml(String url, String username, String password, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
                .body(body)
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void postMultipart(String url, String token, Map<String,Object> body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token, body))
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void postMultipart(String url, String token, Map<String,Object> body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token, body))
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void postMultipart(String url, String username, String password, Map<String,Object> body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .post(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void postMultipart(String url, String username, String password, Map<String,Object> body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .post(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void put(String url, String token, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void put(String url, String token, Object body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void put(String url, String username, String password, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void put(String url, String username, String password, Object body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void putXml(String url, String token, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(token))
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void putXml(String url, String username, String password, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
                .body(body)
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void putMultipart(String url, String token, Map<String,Object> body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token, body))
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void putMultipart(String url, String token, Map<String,Object> body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token, body))
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void putMultipart(String url, String username, String password, Map<String,Object> body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .put(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void putMultipart(String url, String username, String password, Map<String,Object> body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .put(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void get(String url, String token, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .get(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void get(String url, String token, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .get(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void get(String url, String username, String password, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .get(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void get(String url, String username, String password, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .get(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void delete(String url, String token, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .delete(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void delete(String url, String token, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .delete(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void delete(String url, String username, String password, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .delete(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void delete(String url, String username, String password, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .delete(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String token, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String token, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .when()
                .patch(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String username, String password, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String username, String password, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .when()
                .patch(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String token, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String token, Object body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .patch(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String username, String password, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patch(String url, String username, String password, Object body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecJson(username, password))
                .body(body)
                .when()
                .patch(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void patchXml(String url, String token, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(token))
                .body(body)
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patchXml(String url, String username, String password, Object body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecXml(username, password))
                .body(body)
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patchMultipart(String url, String token, Map<String,Object> body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token, body))
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patchMultipart(String url, String token, Map<String,Object> body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(token, body))
                .when()
                .patch(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }

    @Override
    public void patchMultipart(String url, String username, String password, Map<String,Object> body, int resCode) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .patch(url)
                .then()
                .statusCode(resCode);
    }

    @Override
    public void patchMultipart(String url, String username, String password, Map<String,Object> body, int resCode, String jsonSchemaPath) {
        SerenityRest
                .given()
                .spec(spesificationFactory.requestSpecFormData(username, password, body))
                .when()
                .patch(url)
                .then()
                .body(matchesJsonSchemaInClasspath(jsonSchemaPath))
                .statusCode(resCode);
    }
}
