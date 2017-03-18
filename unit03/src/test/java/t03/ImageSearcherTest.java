package t03;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;


public class ImageSearcherTest {

    @Test
    public void testSplitingToSentence(){
        int numOfSentences;
        ImageSearcher parser = new ImageSearcher();
        String text = "<div>Hello. Second sentence. Third sentence.";
        numOfSentences = parser.splitToSentences(text).size();
        assertEquals(3,numOfSentences);
    }

    @Test
    public void testGettingWholeArticle() throws IOException {
        ImageSearcher searcher = new ImageSearcher();
        searcher.getLinesOfArticle();
    }

    @Test
    public void testFindingSentenceWithImage() throws IOException {
        ImageSearcher searcher = new ImageSearcher();
        String s = "В электронах (Рис. 5) свободные пространства расположены между элементарными трубками, а элементарные трубки состоят из элементарных зарядов противоположного знака.";
        assertEquals(true, searcher.findSentencesWithImages(s));
    }

    @Test
    public void testGettingOnlyBody() throws IOException {
        ImageSearcher searcher = new ImageSearcher();
        List<String> body = searcher.getOnlyBodyWithArticle();
        //assertTrue(body.get(0).contains("<body>"));
    }



}