package builder;

import net.serenitybdd.rest.SerenityRest;

public class RequestBuilder {

    private String method;
    private String path;
    private String body;
    private String token;
    private Integer statusCode;
    private String jsonSchemaPath;

    public RequestBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    public RequestBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public RequestBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public RequestBuilder setToken(String  token) {
        this.token = token;
        return this;
    }

    public RequestBuilder setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public RequestBuilder setJsonSchemaPath(String jsonSchemaPath) {
        this.jsonSchemaPath = jsonSchemaPath;
        return this;
    }

    /**
     * Method untuk melakukan request Post menggunakan parameter yg diinputkan oleh user
     * @return
     */
    public Post doPostReq(){
        return new Post(path, body, token, statusCode, jsonSchemaPath);
    }

    /**
     * Method untuk melakukan request Put menggunakan parameter yg diinputkan oleh user
     * @return
     */
    public Put doPutReq(){
        return new Put(path, body, token, statusCode, jsonSchemaPath);
    }

    /**
     * Method untuk melakukan request Get menggunakan parameter yg diinputkan oleh user
     * @return
     */
    public Get doGetReq(){
        return new Get(path, token, statusCode, jsonSchemaPath);
    }

    /**
     * Method untuk melakukan request Delete menggunakan parameter yg diinputkan oleh user
     * @return
     */
    public Delete doDeleteReq(){
        return new Delete(path, token, statusCode, jsonSchemaPath);
    }

    /**
     *
     * @return
     */
    public Request sendIt(){
        return new Request(method, path, body, token, statusCode, jsonSchemaPath);
    }


    /**
     * Method untuk mengambil nilai dari response
     * @param resPath
     * @return
     */
    public String getResponse(String resPath) {
        return SerenityRest
                .then()
                .extract()
                .path(resPath);
    }

}
