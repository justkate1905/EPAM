package t02;

import org.junit.Test;
import java.io.File;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class PropertiesReaderTest {
    @Test
    public void testGetExistingValue() throws Exception {
        File props = new File("src\\main\\resources\\films_en_UK.properties");
        String key = "sherlock";

        String value = PropertiesReader.getValue(props, key);

        assertThat(value, is("Sherlock"));
    }

    @Test
    public void testGetNotExistingValue() throws Exception {
        File props = new File("src\\main\\resources\\films_ru_RU.properties");
        String key = "melon";

        String value = PropertiesReader.getValue(props, key);

        assertThat(value, is("Key is absent in property file"));
    }

    @Test
    public void testGetValueFromNotExistingFile() throws Exception {
        File props = new File("src\\main\\resources\\films_ua.properties");
        String key = "sherlock";

        String value = PropertiesReader.getValue(props, key);

        assertThat(value, is("Property file not found"));
    }
}