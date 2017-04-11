package t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katerina on 10.04.2017.
 */
public class PropertiesReader {

    public Map<String,String> readProperty(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        Map<String, String> properties = new HashMap<String, String>();
        while((line = bufferedReader.readLine())!=null){
            properties.put((line.split("=")[0].trim()),
                    line.split("=")[1].trim());
        }
        return properties;
    }

}
