package t03;

import java.io.*;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class ImageSearcher {

    public static final Pattern patternForRef =
            Pattern.compile("\\([Рр]ис\\. ?\\d+(, ?\\d+)*(( и \\d+)|(-[а-я](,[а-я])*))?\\)");

    public static final Pattern patternForNumber = Pattern.compile("\\d+");

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

    public void findSentencesWithImages(String line) {
        String pattern = "";
    }

    public List<String> splitToSentences(String text) {
        List<String> sentences = new ArrayList<String>();

        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.getDefault());
        iterator.setText(text);

        int start = iterator.first();

        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            sentences.add(text.substring(start, end));
        }
        return sentences;
    }

}
