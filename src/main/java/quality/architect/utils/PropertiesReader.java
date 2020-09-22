package quality.architect.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    /**
     * synchronized dan volatile digunakan untuk menghandle singleton di multi thread Java
     */

    private static volatile PropertiesReader propInstance;

    public PropertiesReader(){}

    public static synchronized PropertiesReader getInstance(){

        if (propInstance==null){
            propInstance = new PropertiesReader();
        }
        return propInstance;
    }

    /**
     * Method yang digunakan untuk mengambil value dari file .properties
     * @param propertyName
     * @return
     */
    public String getProperties(String propertyName){

        Properties prop = new Properties();

        try{

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties");

            prop.load(inputStream);

            if (prop.getProperty(propertyName) != null){
                return prop.getProperty(propertyName);
            } else {
                System.out.println("Property Not Found or Not Match");
            }

        } catch (Exception e){

            System.out.println("File Not Found");

        }

        return null;

    }

}
