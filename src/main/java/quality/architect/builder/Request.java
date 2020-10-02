package quality.architect.builder;

import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Request {

    private final String method;
    private final String url;
    private final Object body;
    private final String token;
    private final Integer statusCode;
    private final String jsonSchemaPath;
    private SpesificationFactory spesificationFactory;

    /**
     * Post constructor, yang dipanggil ketika digunakan untuk melakukan request Post
     * @param method request method yang ingin digunakan
     * @param url url lengkap yang akan diuji
     * @param body body request yang ingin digunakan
     * @param token Token bearer jika dibutuhkan
     * @param statusCode status code yang kita ekpektasikan
     * @param jsonSchemaPath path file json schema yang ingin kita gunakan
     */
    Request (String method, String url, Object body, String token, Integer statusCode, String jsonSchemaPath) {

        this.method = method;
        this.url = url;
        this.body = body;
        this.token = token;
        this.statusCode = statusCode;
        this.jsonSchemaPath = jsonSchemaPath;

        hitEndpoint(token, body, url);
        valEndpoint(statusCode, jsonSchemaPath);

    }

    private void hitEndpoint(String token, Object body, String url){

        spesificationFactory = new SpesificationFactory();

        switch (method.toUpperCase()){
            case "POST":
                SerenityRest
                        .given()
                        .spec(spesificationFactory.requestSpecJson(token))
                        .body(body)
                        .when()
                        .post(url);
                break;
            case "PUT":
                SerenityRest
                        .given()
                        .spec(spesificationFactory.requestSpecJson(token))
                        .body(body)
                        .when()
                        .put(url);
                break;
            case "GET":
                SerenityRest
                        .given()
                        .spec(spesificationFactory.requestSpecJson(token))
                        .when()
                        .get(url);
                break;
            case "DELETE":
                SerenityRest
                        .given()
                        .spec(spesificationFactory.requestSpecJson(token))
                        .when()
                        .delete(url);
                break;
            default:
                System.out.println("Method Undefined");

        }
    }

    private void valEndpoint(Integer statusCode, String jsonSchemaPath){
        if (statusCode == null || jsonSchemaPath == null) {
            if (statusCode != null) {
                SerenityRest
                        .then()
                        .statusCode(statusCode);
            } else if (jsonSchemaPath != null){
                SerenityRest
                        .then()
                        .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
            }
        } else {
            SerenityRest
                    .then()
                    .statusCode(statusCode)
                    .body(matchesJsonSchemaInClasspath(jsonSchemaPath));
        }
    }
}
