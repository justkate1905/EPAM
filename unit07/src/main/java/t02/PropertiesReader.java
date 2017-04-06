package t02;

import java.io.*;
import java.util.MissingResourceException;
import java.util.Properties;

@SuppressWarnings("ALL")
public class PropertiesReader {

    static Properties properties = new Properties();

    public static synchronized String getValue(File propertiesFile, String key) {
        try {
            if (properties.isEmpty()) {
                FileInputStream fileInputStream = new FileInputStream(propertiesFile);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                properties.load(bufferedReader);
            }

            String value = properties.getProperty(key);

            if (value == null) {
                throw new MissingResourceException("Key is absent in property file", "PropertiesReader", key);
            } else {
                return value;
            }

            } catch (IOException e) {
                return "Property file not found";
            } catch (MissingResourceException e) {
                return e.getMessage();
            }

    }
}
