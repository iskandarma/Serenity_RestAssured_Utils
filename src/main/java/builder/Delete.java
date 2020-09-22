package builder;

import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;
import quality.architect.utils.TestBase;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class Delete {

    private final String path;
    private final String token;
    private final Integer statusCode;
    private final String jsonSchemaPath;

    /**
     * Delete constructor, yang dipanggil ketika digunakan untuk melakukan request Delete
     *
     * @param path
     * @param token
     * @param statusCode
     * @param jsonSchemaPath
     */
    Delete (String path, String token, Integer statusCode, String jsonSchemaPath) {
        this.path = path;
        this.token = token;
        this.statusCode = statusCode;
        this.jsonSchemaPath = jsonSchemaPath;

        TestBase.getUrl();

        SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .delete(path);

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
