package t02;

import org.intellij.lang.annotations.Language;

import java.io.*;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by Katerina on 27.03.2017.
 */
@SuppressWarnings("Since15")
public class PropertiesReader {
    public static String getValue(File propertiesFile, String key) {
        try {

            FileInputStream fileInputStream = new FileInputStream(propertiesFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Properties properties = new Properties();

            properties.load(bufferedReader);

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
