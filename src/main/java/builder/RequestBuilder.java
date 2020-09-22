package builder;

import net.serenitybdd.rest.SerenityRest;

public class RequestBuilder {

    private String method;
    private String path;
    private Object body;
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

    public RequestBuilder setBody(Object body) {
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
