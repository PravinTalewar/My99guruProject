package Utills;

import org.testng.Assert;

import java.util.Properties;

public class BaseTest {
    protected String url;
    protected String username;
    protected String password;

    public BaseTest() {
        readProperties();
    }

    public void readProperties() {
        try {
            Properties properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            this.url = (String) properties.get("url");
            this.username = (String) properties.get("username");
            this.password = (String) properties.get("password");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Config.properties file not found");
        }
    }
}
