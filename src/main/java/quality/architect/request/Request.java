package quality.architect.request;

    /**
     * All request method
     **/
public interface Request {

        /**
         * Post request using JWT Token for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void post(String url, String token, Object body, int resCode);

        /**
         * Post request using JWT Token for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void post(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request using basic auth for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void post(String url, String username, String password, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void post(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request using JWT Token for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void postXml(String url, String token, Object body, int resCode);

        /**
         * Post request using JWT Token for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void postXml(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request using basic auth for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void postXml(String url, String username, String password, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void postXml(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request using JWT Token for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void postMultipart(String url, String token, Object body, int resCode);

        /**
         * Post request using JWT Token for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void postMultipart(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request using basic auth for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void postMultipart(String url, String username, String password, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void postMultipart(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request using JWT Token for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void put(String url, String token, Object body, int resCode);

        /**
         * Put request using JWT Token for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void put(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request using basic auth for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void put(String url, String username, String password, Object body, int resCode);

        /**
         * Put request using basic auth for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void put(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request using JWT Token for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void putXml(String url, String token, Object body, int resCode);

        /**
         * Put request using JWT Token for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void putXml(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request using basic auth for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void putXml(String url, String username, String password, Object body, int resCode);

        /**
         * Put request using basic auth for authentication and XML for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void putXml(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request using JWT Token for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void putMultipart(String url, String token, Object body, int resCode);

        /**
         * Put request using JWT Token for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void putMultipart(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request using basic auth for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void putMultipart(String url, String username, String password, Object body, int resCode);

        /**
         * Put request using basic auth for authentication and Multipart/form-data for request body.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void putMultipart(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Get request using JWT Token for authentication.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         */
    void get(String url, String token, int resCode);

        /**
         * Get request using JWT Token for authentication and JSON Schema Path..
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void get(String url, String token, int resCode, String jsonSchemaPath);

        /**
         * Get request using basic auth for authentication.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         */
    void get(String url, String username, String password, int resCode);

        /**
         * Get request using basic auth for authentication and JSON Schema Path.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void get(String url, String username, String password, int resCode, String jsonSchemaPath);

        /**
         * Delete request using JWT Token for authentication.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         */
    void delete(String url, String token, int resCode);

        /**
         * Delete request using JWT Token for authentication and JSON Schema Path.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void delete(String url, String token, int resCode, String jsonSchemaPath);

        /**
         * Delete request using basic auth for authentication.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         */
    void delete(String url, String username, String password, int resCode);

        /**
         * Get request using basic auth for authentication and JSON Schema Path.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void delete(String url, String username, String password, int resCode, String jsonSchemaPath);

        /**
         * Patch request using JWT Token for authentication.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         */
    void patch(String url, String token, int resCode);

        /**
         * Patch request using JWT Token for authentication and JSON Schema Path.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String token, int resCode, String jsonSchemaPath);

        /**
         * Patch request using basic auth for authentication.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         */
    void patch(String url, String username, String password, int resCode);

        /**
         * Patch request using basic auth for authentication and JSON Schema Path.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String username, String password, int resCode, String jsonSchemaPath);

        /**
         * Patch request using JWT Token for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void patch(String url, String token, Object body, int resCode);

        /**
         * Patch request using JWT Token for authentication and JSON for request body.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request using basic auth for authentication and JSON for request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void patch(String url, String username, String password, Object body, int resCode);

        /**
         * Patch request using basic auth for authentication and JSON for request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request using JWT Token for authentication and XML for request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void patchXml(String url, String token, Object body, int resCode);

        /**
         * Patch request using JWT Token for authentication and XML for request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patchXml(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request using basic auth for authentication and XML for request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void patchXml(String url, String username, String password, Object body, int resCode);

        /**
         * Patch request using basic auth for authentication and XML for request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patchXml(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request using JWT Token for authentication and Multipart/form-data for request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void patchMultipart(String url, String token, Object body, int resCode);

        /**
         * Patch request using JWT Token for authentication and Multipart/form-data for request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patchMultipart(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request using basic auth for authentication and Multipart/form-data for request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void patchMultipart(String url, String username, String password, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and Multipart/form-data for request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patchMultipart(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

}
