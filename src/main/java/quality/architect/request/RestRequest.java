package quality.architect.request;

    /**
     * All request method
     **/
public interface RestRequest {
        /**
         * Post request using JWT Token for authentication and JSON for request body
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @return
         */
    void post(String url, String token, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and JSON for request body
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The JSON body request to send.
         * @param resCode The response code.
         * @return
         */
    void post(String url, String username, String password, Object body, int resCode);

        /**
         * Post request using JWT Token for authentication and XML for request body
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @return
         */
    void postXml(String url, String token, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and XML for request body
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The XML body request to send.
         * @param resCode The response code.
         * @return
         */
    void postXml(String url, String username, String password, Object body, int resCode);

        /**
         * Post request using JWT Token for authentication and Multipart/form-data for request body
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @return
         */
    void postMultipart(String url, String token, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and Multipart/form-data for request body
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The Multipart/form-data body request to send.
         * @param resCode The response code.
         * @return
         */
    void postMultipart(String url, String username, String password, Object body, int resCode);



}
