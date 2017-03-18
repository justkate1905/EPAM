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
            Pattern.compile("(\\([Рр]ис\\. ?\\d+(, ?\\d+)*(( и \\d+)|(-[а-я](,[а-я])*))?\\))| [Рр]исунке ?\\d+ ");

    public static final Pattern patternForFullRef =
            Pattern.compile("\\([Рр]исунке ?\\d+(, ?\\d+)*(( и \\d+)|(-[а-я](,[а-я])*))?\\)");

    public static final Pattern patternForNumber = Pattern.compile("\\d+");

    public static StringBuilder newHtml = new StringBuilder();


    private final String inputFile = "Article.html";
    private final String outputFile = "MarkedArticle.html";


    public List<String> getLinesOfArticle() {
        List<String> article = new ArrayList<String>();
        try {


            FileInputStream fileInputStream = new FileInputStream(inputFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "windows-1251");

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                article.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return article;
    }


    public boolean checkForRightImageSequence() {
        List<String> article = splitToSentences();
        Matcher matcherForImage;
        Matcher matcherForNumber;
        int currentImage = 0;
        int parsedImage;
        for (String s : findSentencesWithImages(article)) {

            matcherForImage = patternForRef.matcher(s);
            if (matcherForImage.find()) {
                matcherForNumber = patternForNumber.matcher(matcherForImage.group());
                if (matcherForNumber.find()) {
                    parsedImage = Integer.parseInt(matcherForNumber.group());
                    if (parsedImage >= currentImage) {
                        currentImage = parsedImage;
                    } else {
                        System.out.println("Reference on images isn't right!");
                        return false;
                    }
                }

            }
        }
        return true;
    }

    public void makeFileWithMarkedSentences() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "windows-1251");

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        makeHeadOfHtml(getLinesOfArticle());

        List<String> body = getOnlyBodyWithArticle();


        for (String sentence : splitToSentences()) {
            if (checkIsSentenceContainsImage(sentence)) {
                sentence = markSentenceWithImages(sentence);
            }
            newHtml.append(sentence);
        }
        bufferedWriter.write(newHtml.toString());
        bufferedWriter.close();
    }


    public List<String> getOnlyBodyWithArticle() {
        List<String> body = new ArrayList<String>();
        int index = 0;
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
        return body;
    }

    private void makeHeadOfHtml(List<String> article) {
        for (int i = 0; i < article.size(); i++) {
            newHtml.append(article.get(i));
            break;
        }
    }

    public String markSentenceWithImages(String sentence) {
        return "<b>" + sentence + "</b>";
    }

    public List<String> findSentencesWithImages(List<String> article) {
        List<String> sentencesWithImage = new ArrayList<String>();
        for (String s : article) {
            if (checkIsSentenceContainsImage(s)) {
                sentencesWithImage.add(s);
            }
        }
        return sentencesWithImage;
    }


    public boolean checkIsSentenceContainsImage(String sentence) {
        Matcher matcher = patternForRef.matcher(sentence);
        if (!matcher.find()) {
            return false;
        }
        return true;
    }


    public List<String> splitToSentences() {
        List<String> sentences = new ArrayList<String>();

        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.getDefault());
        int start;
        for (String s : getOnlyBodyWithArticle()) {
            iterator.setText(s);
            start = iterator.first();
            for (int end = iterator.next();
                 end != BreakIterator.DONE;
                 start = end, end = iterator.next()) {
                sentences.add(s.substring(start, end));
            }
        }
        return sentences;
    }

}
