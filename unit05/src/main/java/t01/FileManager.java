package t01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Since15")
public class FileManager {

    public static final String FILES = "f";
    public static final String DIRS = "d";
    public static final String ALL = "all";


    public String currentPath = System.getProperty("user.dir");

    public List<String> getRequiredList(String path, String type) {
        List<String> requiredList = new ArrayList<String>();
        File dir = new File(path);
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
                case ALL:
                    requiredList.add(entry.getName());
                    break;
            }
        }
        return requiredList;
    }

    public void goToDirectory(String src) {
        String temp;
        if (src.contains("\\")) {
            temp = src;
        } else {
            temp = currentPath + "\\" + src;
        }
        File file = new File(temp);
        if (file.exists()) {
            if (file.isDirectory()) {
                currentPath = temp;
            } else {
                System.out.println("File is not directory");
            }
        } else {
            try {
                throw new NoSuchFileException(temp);
            } catch (NoSuchFileException e) {
                System.out.println("No such directory");
            }
        }
    }


    public void goUp() {
        File file = new File(currentPath);
        currentPath = file.getParentFile().toString();
    }

    public int create(String name, String type) {
        if (!type.equals("txt")) {
            System.out.println("You can create only text files");
            return -1;
        }
        final String pathname = currentPath + "\\" + name + "." + type;
        File file = new File(pathname);

        if (!file.exists()) {
            try {
                file.createNewFile();
                return 0;

            } catch (IOException e) {
                return 1;
            }

        } else {
            try {
                throw new FileAlreadyExistsException(pathname);
            } catch (FileAlreadyExistsException e) {
                return 1;
            }
        }
    }

    public int delete(String nameOfFile) {

        final String pathname = currentPath + "\\" + nameOfFile;
        File file = new File(pathname);

        if (file.exists()) {
            if (!nameOfFile.endsWith(".txt")) {
                System.out.println("You can delete only text files");
                return -1;
            }
            file.delete();
            return 0;

        } else {
            try {
                throw new IOException("No such file");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return 1;
            }
        }
    }

    public int write(String fileName, String text, boolean flag) {
        String path;
        if (fileName.contains("\\")) {
            path = fileName;
        } else {
            path = currentPath + "\\" + fileName;
        }
        try {
            File file = new File(path);
            if (file.exists()) {
                if (!path.endsWith(".txt")) {
                    return 1;
                }
                FileWriter fileWriter = new FileWriter(file, flag);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
                return 0;
            } else {
                System.out.println("No such file");
                return 1;
            }
        } catch (IOException e) {
            return -1;
        }
    }

    public int read(String fileName) {
        String path;
        StringBuilder text = new StringBuilder();
        if (fileName.contains("\\")) {
            path = fileName;
        } else {
            path = currentPath + "\\" + fileName;
        }
        try {
            File file = new File(path);
            if (file.exists()) {
                if (!path.endsWith(".txt")) {
                    System.out.println("You can read only text files!");
                    return 1;
                }
                FileReader fileReader = new FileReader(file);
                int c;
                while ((c = fileReader.read()) != -1) {
                    text.append((char)c);
                }
                fileReader.close();
                System.out.println(text.toString());
                return 0;
            } else {
                System.out.println("No such file");
                return 1;
            }
        } catch (IOException e) {
            return -1;
        }
    }
}
