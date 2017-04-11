package t02;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Katerina on 11.04.2017.
 */
public class PropertiesReaderTest {
    @Test
    public void readProperty() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();

        Map<String, String> properties = propertiesReader.readProperty("src\\main\\resources\\films_en_UK.properties");

        assertThat(properties.get("sherlock"), is("Sherlock"));
    }

}