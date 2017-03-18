package t03;

import java.io.*;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageSearcher {

    public static final Pattern patternForRef =
            Pattern.compile("\\([Рр]ис\\. ?\\d+(, ?\\d+)*(( и \\d+)|(-[а-я](,[а-я])*))?\\)");

    public static final Pattern patternForNumber = Pattern.compile("\\d+");

    public static StringBuilder html = new StringBuilder();

    private final String path = "Article.html";


    public List<String> getLinesOfArticle() throws IOException {
        List<String> article = new ArrayList<String>();

        FileReader fileReader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            article.add(line);
        }
        return article;

    }


    public void checkForRightImageSequence() {

    }

    public List<String> getOnlyBodyWithArticle() throws IOException {
        List<String> body = new ArrayList<String>();
        int index = 0;
        try {
            List<String> article = getLinesOfArticle();
            for (int i = 0; i < article.size(); i++) {
                if (article.get(i).contains("<body>")) {
                    index = i;
                    break;
                }
            }
            for (int i = index; i < article.size(); i++) {
                body.add(article.get(i));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return body;
    }

    public void markSentenceWithMark(String sentence) {
        html.append("<b>")
                .append(sentence)
                .append("</b>");
    }

    public boolean findSentencesWithImages(String sentence) {
        Matcher matcher = patternForRef.matcher(sentence);
        if (!matcher.find()) {
            return false;
        }
        return true;
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
