package t03;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Katerina on 13.03.2017.
 */
public class ImageSearcherTest {

    @Test
    public void testSplitingToSentence(){
        int numOfSentences = 0;
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