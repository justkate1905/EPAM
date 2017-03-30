package t01;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Since15")
public class FileManager {

    public static final String FILES = "f";
    public static final  String DIRS = "d";

    public String currentPath = Paths.get("").toAbsolutePath().toString();

    public List<String> getRequiredList(String s, String type) {
        List<String> requiredList = new ArrayList<String>();
        File dir = new File(s);
        for (File entry : dir.listFiles()) {
            switch (type) {
                case FILES:
                    if (!entry.isDirectory()) {
                        requiredList.add(entry.getName());
                    }
                    break;
                case DIRS:
                    if (entry.isDirectory()) {
                        requiredList.add(entry.getName());
                    }
                    break;
            }
        }

        return requiredList;
    }

    public void goToDirectory(String src) {
        currentPath = currentPath+"\\"+src;
    }

    public void goUp(){


    }
}
