package dataprovider;
import java.io.*;
import java.util.Properties;

public class ConfigReader {

    protected static Properties properties;

    public ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "C:\\Users\\user\\IdeaProjects\\Fresha\\configs\\configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("base_Url");
        if(baseUrl != null) {
            return baseUrl;
        } else {
            throw new RuntimeException("base_Url not specified in the configuration.properties file.");
        }
    }

    public String getUserUrl() {
        String urlForCustomer = properties.getProperty("urlForCustomer");
        if(urlForCustomer != null) {
            return urlForCustomer;
        } else {
            throw new RuntimeException("urlForCustomer not specified in the configuration.properties file.");
        }
    }

    public String getUserID() {
        String userId = properties.getProperty("user_Id");
        if(userId != null) {
            return userId;
        } else {
            throw new RuntimeException("user_Id not specified in the configuration.properties file.");
        }
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if(password != null) {
            return password;
        } else {
            throw new RuntimeException("password not specified in the configuration.properties file.");
        }
    }
}


