package t02;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class PropertiesReaderTest {
    @Test
    public void testGetExistingValue() throws Exception {
        final File props = new File("src\\main\\resources\\films_en_UK.properties");
        String key = "sherlock";
        final String key1 = "xMen";
        Thread t2 = new Thread() {
            {
                String xMen = PropertiesReader.getValue(props, key1);
                System.out.println(xMen);
            }
        };

        t2.run();
        String value = PropertiesReader.getValue(props, key);

        assertThat(value, is("Sherlock"));
    }
}