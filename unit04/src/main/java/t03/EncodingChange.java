package t03;

import java.io.*;

/**
 * Created by Katerina on 19.03.2017.
 */
public class EncodingChange {
    public static String inputFile;
    public static String outputFile;

    public EncodingChange() {
        inputFile = "cyrillicSymbols.txt";
        outputFile = "cyrillicSymbolsUTF16.txt";
    }

    public void ChangeEncoding(){
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-16");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
            }
            bufferedWriter.flush();

            fileInputStream.close();
            fileOutputStream.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.toString());
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }

}
