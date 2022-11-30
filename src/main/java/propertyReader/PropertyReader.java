package propertyReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    public PropertyReader(String propertiesName) {
        properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/main/resources/" + propertiesName + ".properties");
            properties.load(inputStream);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
