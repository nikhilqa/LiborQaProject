package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties readProperty;

    public static String readProjectConfig(String key) {
        String propertyValue = null;

        try {
            FileReader reader = new FileReader(new File("ConfigFiles/ProjectConfig.properties"));

            readProperty = new Properties();
            readProperty.load(reader);
            return readProperty.getProperty(key).trim();

        } catch (IOException e) {
            e.printStackTrace();
            throw (new RuntimeException("ERROR While Reading" + key));
        }
    }
}
