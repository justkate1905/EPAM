package t04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 20.03.2017.
 */
public class Films implements Serializable {

    private List<Film> films = new ArrayList<Film>();

    public static void serialize(List<Film> collection, String path) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(collection);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static ArrayList<Film> deserialize(String path) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(path);
        List<Film> filmsList = new ArrayList<Film>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            filmsList = (List<Film>) objectInputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (ArrayList<Film>) filmsList;
    }

}
