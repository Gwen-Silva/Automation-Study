package tests.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load test configuration.", e);
        }
    }

    public static String getUrl() {
        String url = properties.getProperty("baseUrl");
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalStateException("Missing baseUrl in test configuration.");
        }
        return url;
    }
}
