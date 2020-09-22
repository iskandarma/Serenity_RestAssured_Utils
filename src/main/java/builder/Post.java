package builder;

import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;
import quality.architect.utils.TestBase;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Post {

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
    Post(String path, String body, String token, Integer statusCode, String jsonSchemaPath) {
        this.path = path;
        this.body = body;
        this.token = token;
        this.statusCode = statusCode;
        this.jsonSchemaPath = jsonSchemaPath;

        TestBase.getUrl();

        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(path);

        if (statusCode == null || jsonSchemaPath == null) {
            if (statusCode != null) {
                SerenityRest
                        .then()
                        .statusCode(statusCode);
            } else {
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
