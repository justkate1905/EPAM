package t03;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;


public class ImageSearcherTest {

    @Test
    public void testSplitingToSentence(){
        int numOfSentences;
        ImageSearcher parser = new ImageSearcher();
        String text = "Hello. Second sentence. Third sentence.";
        numOfSentences = parser.splitToSentences(text).size();
        assertEquals(3,numOfSentences);
    }

    @Test
    public void testGettingWholeArticle() throws IOException {
        ImageSearcher searcher = new ImageSearcher();
        searcher.getArticle();
    }

}