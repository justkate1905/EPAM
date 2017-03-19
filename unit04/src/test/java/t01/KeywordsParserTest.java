package t01;

import org.junit.Test;

import java.security.Key;

import static org.junit.Assert.*;

/**
 * Created by Katerina on 20.03.2017.
 */
public class KeywordsParserTest {
    @Test
    public void testCountingFileWithKeyWords() throws Exception {
        KeywordsParser keywordsParser = KeywordsParser.build("keyWords.txt","ImageSearcher.java","countFile.txt");
        keywordsParser.makeFileWithKeyWordsCount();

    }

}