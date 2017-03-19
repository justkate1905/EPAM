package t03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Katerina on 19.03.2017.
 */
public class EncodingChangeTest  {
    @Test
    public void changeEncoding() throws Exception {
        EncodingChange encodingChange = new EncodingChange();

        encodingChange.ChangeEncoding();
    }

}