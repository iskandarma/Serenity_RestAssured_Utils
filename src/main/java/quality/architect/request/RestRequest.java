package quality.architect.request;

    /**
     * All request method
     **/
public interface RestRequest {
        /**
         * Post request using JWT Token for authentication and JSON for request body
         * @param url The URL of endpoint.
         * @param token The JWT token.
         * @param body The body request to send.
         * @param resCode The response code.
         * @return
         */
    RestRequest post(String url, String token, Object body, int resCode);

        /**
         * Post request using basic auth for authentication and JSON for request body
         * @param url The URL of endpoint.
         * @param username The username.
         * @param password The password.
         * @param body The body request to send.
         * @param resCode The response code.
         * @return
         */
    RestRequest post(String url, String username, String password, Object body, int resCode);

        /**
         *
         * @param url
         * @param token
         * @param resCode
         * @return
         */
    RestRequest get(String url, String token, int resCode);

}
