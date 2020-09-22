package quality.architect.utils;

import io.restassured.RestAssured;

public class TestBase {

    public static PropertiesReader propertiesReader;

    public static void getUrl(){

        propertiesReader = PropertiesReader.getInstance();

        RestAssured.baseURI = propertiesReader.getProperties("baseUrl");

    }

}
