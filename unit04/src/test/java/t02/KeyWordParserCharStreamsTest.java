package t02;

import org.junit.Test;
import t01.KeywordsParser;

import static org.junit.Assert.*;

/**
 * Created by Katerina on 20.03.2017.
 */
public class KeyWordParserCharStreamsTest {
    @Test
    public void makeFileWithKeyWordsCount() throws Exception {
        KeyWordParserCharStreams keywordsParser = KeyWordParserCharStreams.build("keyWords.txt","ImageSearcher.java","countFileByCharStream.txt");
        keywordsParser.makeFileWithKeyWordsCount();
    }

}