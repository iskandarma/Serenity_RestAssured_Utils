package quality.architect.request;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import quality.architect.spec.SpesificationFactory;
import quality.architect.utils.TestBase;

public class RestClient {

    /**
     * Fungsi untuk melakukan request dengan method Get
     * @param path
     * @return
     */
    public Response doGetRequest(String path){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .when()
                .get(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Get dan token
     * @param path
     * @return
     */
    public Response doGetRequest(String path, String token){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .get(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Post
     * @param path
     * @param body
     * @return
     */
    public Response doPostRequest(String path, Object body){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson())
                .body(body)
                .when()
                .post(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Post dan token
     * @param path
     * @param body
     * @return
     */
    public Response doPostRequest(String path, Object body, String token){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .post(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Put
     * @param path
     * @param body
     * @return
     */
    public Response doPutRequest(String path, Object body){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson())
                .body(body)
                .when()
                .put(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Put dan token
     * @param path
     * @param body
     * @return
     */
    public Response doPutRequest(String path, Object body, String token){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .body(body)
                .when()
                .put(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Delete
     * @param path
     * @return
     */
    public Response doDeleteRequest(String path){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .when()
                .delete(path);
    }

    /**
     * Fungsi untuk melakukan request dengan method Delete dan token
     * @param path
     * @return
     */
    public Response doDeleteRequest(String path, String token){
        TestBase.getUrl();
        return SerenityRest
                .given()
                .spec(SpesificationFactory.requestSpecJson(token))
                .when()
                .delete(path);
    }


}
