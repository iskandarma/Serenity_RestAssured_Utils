package builder;

import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;
import quality.architect.utils.TestBase;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Request {

    private final String method;
    private final String path;
    private final String body;
    private final String token;
    private final Integer statusCode;
    private final String jsonSchemaPath;

    /**
     * Post constructor, yang dipanggil ketika digunakan untuk melakukan request Post
     *
     * @param path
     * @param body
     * @param token
     * @param statusCode
     * @param jsonSchemaPath
     */
    Request (String method, String path, String body, String token, Integer statusCode, String jsonSchemaPath) {

        this.method = method;
        this.path = path;
        this.body = body;
        this.token = token;
        this.statusCode = statusCode;
        this.jsonSchemaPath = jsonSchemaPath;

        TestBase.getUrl();

        switch (method.toUpperCase()){
            case "POST":
                SerenityRest
                        .given()
                        .spec(SpesificationFactory.requestSpecJson(token))
                        .body(body)
                        .when()
                        .post(path);
                break;
            case "PUT":
                SerenityRest
                        .given()
                        .spec(SpesificationFactory.requestSpecJson(token))
                        .body(body)
                        .when()
                        .put(path);
                break;
            case "GET":
                SerenityRest
                        .given()
                        .spec(SpesificationFactory.requestSpecJson(token))
                        .when()
                        .get(path);
                break;
            case "DELETE":
                SerenityRest
                        .given()
                        .spec(SpesificationFactory.requestSpecJson(token))
                        .when()
                        .delete(path);
                break;
            default:
                System.out.println("Method Undefined");

        }

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
