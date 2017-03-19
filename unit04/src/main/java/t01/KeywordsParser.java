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
    public KeywordsParser(){

    }
    public KeywordsParser(String keyWords, String input, String output){
        keywordsFile = keyWords;
        inputFile = input;
        outputFile = output;
    }

    public static KeywordsParser build(String keyWords, String input, String output){
        return new KeywordsParser(keyWords, input, output);
    }

    private void makeKeyWordsMap(String keywordsFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(keywordsFile);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        while((line = bufferedReader.readLine())!=null){
            for (String s : line.split(" ")) {
                keyWords.put(s,0);
            }
        }
        bufferedReader.close();

    }

    public void makeFileWithKeyWordsCount(){
        try{
            makeKeyWordsMap(keywordsFile);
            readCodeFromFile(inputFile);
            writeGystogramToFile(outputFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void readCodeFromFile(String inputFile) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;

        while((line = bufferedReader.readLine())!=null){
            for (String s : line.split(" ")) {
                if(keyWords.containsKey(s)){
                    keyWords.put(s, keyWords.get(s)+1);
                }
            }
        }
    }

    private void writeGystogramToFile(String outputFile) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(getKeyWords().toString());

        bufferedWriter.flush();
        bufferedWriter.close();
    }


    public HashMap<String, Integer> getKeyWords() {
        return new HashMap<String, Integer>(keyWords);
    }
}
