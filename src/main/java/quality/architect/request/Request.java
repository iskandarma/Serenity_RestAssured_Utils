package quality.architect.request;

    /**
     * All request method
     **/
public interface Request {

        /**
         * Post request, JWT token authentication and JSON request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void post(String url, String token, Object body, int resCode);

        /**
         * Post request, JWT token authentication, JSON request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void post(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request, basic authentication and JSON request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void post(String url, String username, String password, Object body, int resCode);

        /**
         * Post request, basic authentication, JSON request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void post(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request, JWT token authentication and XML request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void postXml(String url, String token, Object body, int resCode);

        /**
         * Post request, basic authentication and XML request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void postXml(String url, String username, String password, Object body, int resCode);

        /**
         * Post request, JWT token authentication and multipart/form-data request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void postMultipart(String url, String token, Object body, int resCode);

        /**
         * Post request, JWT token authentication, multipart/form-data request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void postMultipart(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Post request, basic authentication and multipart/form-data request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void postMultipart(String url, String username, String password, Object body, int resCode);

        /**
         * Post request, basic authentication, multipart/form-data request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void postMultipart(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request, JWT token authentication and JSON request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void put(String url, String token, Object body, int resCode);

        /**
         * Put request, JWT token authentication, JSON request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void put(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request, basic authentication and JSON request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void put(String url, String username, String password, Object body, int resCode);

        /**
         * Put request, basic authentication, JSON request body JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void put(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request, JWT token authentication and XML request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void putXml(String url, String token, Object body, int resCode);

        /**
         * Put request, basic authentication and XML request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void putXml(String url, String username, String password, Object body, int resCode);

        /**
         * Put request, JWT token authentication and multipart/form-data request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void putMultipart(String url, String token, Object body, int resCode);

        /**
         * Put request, JWT token authentication and multipart/form-data request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void putMultipart(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Put request, basic authentication and multipart/form-data request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void putMultipart(String url, String username, String password, Object body, int resCode);

        /**
         * Put request, basic authentication, multipart/form-data request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void putMultipart(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Get request and JWT token authentication usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         */
    void get(String url, String token, int resCode);

        /**
         * Get request, JWT token authentication and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void get(String url, String token, int resCode, String jsonSchemaPath);

        /**
         * Get request and basic authentication usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         */
    void get(String url, String username, String password, int resCode);

        /**
         * Get request, basic authentication and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void get(String url, String username, String password, int resCode, String jsonSchemaPath);

        /**
         * Delete request and JWT token authentication usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         */
    void delete(String url, String token, int resCode);

        /**
         * Delete request, JWT token authentication and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void delete(String url, String token, int resCode, String jsonSchemaPath);

        /**
         * Delete request and basic authentication usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         */
    void delete(String url, String username, String password, int resCode);

        /**
         * Delete request, basic authentication and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void delete(String url, String username, String password, int resCode, String jsonSchemaPath);

        /**
         * Patch request and JWT token authentication usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         */
    void patch(String url, String token, int resCode);

        /**
         * Patch request, JWT token authentication and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String token, int resCode, String jsonSchemaPath);

        /**
         * Patch request and basic authentication usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         */
    void patch(String url, String username, String password, int resCode);

        /**
         * Patch request, basic authentication and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String username, String password, int resCode, String jsonSchemaPath);

        /**
         * Patch request, JWT token authentication and JSON request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void patch(String url, String token, Object body, int resCode);

        /**
         * Patch request, JWT token authentication, JSON request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request, basic authentication and JSON request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         */
    void patch(String url, String username, String password, Object body, int resCode);

        /**
         * Patch request, basic authentication, JSON request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patch(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request, JWT token authentication and XML request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void patchXml(String url, String token, Object body, int resCode);

        /**
         * Patch request, basic authentication and XML request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         */
    void patchXml(String url, String username, String password, Object body, int resCode);

        /**
         * Patch request, JWT token authentication and multipart/form-data request body usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void patchMultipart(String url, String token, Object body, int resCode);

        /**
         * Patch request, JWT token authentication, multipart/form-data request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patchMultipart(String url, String token, Object body, int resCode, String jsonSchemaPath);

        /**
         * Patch request, basic authentication and multipart/form-data request body usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         */
    void patchMultipart(String url, String username, String password, Object body, int resCode);

        /**
         * Patch request, basic authentication, multipart/form-data request body and JSON schema validation usage.
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @param jsonSchemaPath The JSON Schema Path. ex : "resources/jsonSchema/jsonSchemaName.json"
         */
    void patchMultipart(String url, String username, String password, Object body, int resCode, String jsonSchemaPath);

}
