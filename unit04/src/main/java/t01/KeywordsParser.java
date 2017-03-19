package t01;

import java.io.*;
import java.util.HashMap;

/**
 * Created by Katerina on 18.03.2017.
 */
public class KeywordsParser {
    public static String keywordsFile;
    public static String inputFile;
    public static String outputFile;

    private HashMap<String, Integer> keyWords = new HashMap<String, Integer>();

    public KeywordsParser() {

    }

    public KeywordsParser(String keyWords, String input, String output) {
        keywordsFile = keyWords;
        inputFile = input;
        outputFile = output;
    }

    public static KeywordsParser build(String keyWords, String input, String output) {
        return new KeywordsParser(keyWords, input, output);
    }

    private void makeKeyWordsMap(String keywordsFile) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(keywordsFile);

        int bytesAvailable = fileInputStream.available();
        byte[] bytesReaded = new byte[bytesAvailable];

        fileInputStream.read(bytesReaded, 0, bytesAvailable);
        String words = new String(bytesReaded);

        fileInputStream.close();

            for (String s : words.split(" ")) {
                keyWords.put(s, 0);
            }

    }

    public void makeFileWithKeyWordsCount() {
        try {
            makeKeyWordsMap(keywordsFile);
            readCodeFromFile(inputFile);
            writeGystogramToFile(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readCodeFromFile(String inputFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);

        int bytesAvailable = fileInputStream.available();

        byte[] bytesReaded = new byte[bytesAvailable];

        fileInputStream.read(bytesReaded, 0, bytesAvailable);
        fileInputStream.close();
        String code = new String(bytesReaded);

        for (String s : code.split(" ")) {
                if (keyWords.containsKey(s)) {
                    keyWords.put(s, keyWords.get(s) + 1);
                }
            }
        }

    private void writeGystogramToFile(String outputFile) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        fileOutputStream.write(getKeyWords().toString().getBytes());

        fileOutputStream.close();
    }


    public HashMap<String, Integer> getKeyWords() {
        return new HashMap<String, Integer>(keyWords);
    }
}
