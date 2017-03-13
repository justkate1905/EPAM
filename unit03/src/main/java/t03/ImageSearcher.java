package t03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Katerina on 12.03.2017.
 */
public class ImageSearcher {

    private final String path = "Article.html";


    public List<String> getArticle() throws IOException {
        List<String> article = new ArrayList<String>();
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line ;
        while ((line = bufferedReader.readLine())!= null) {
            article.add(line);
        }
        return article;

    }


    public void checkForImageSequence() {

    }

    public void findSentencesWithImages() {

    }

    public List<String> splitToSentences(String text) {
        List<String> sentences = new ArrayList<String>();

        return sentences;
    }

}
