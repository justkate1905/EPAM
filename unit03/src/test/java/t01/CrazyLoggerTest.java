package t01;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by Katerina on 07.03.2017.
 */
public class CrazyLoggerTest extends TestCase {

    CrazyLogger logger = new CrazyLogger();

    @Test
    public void testGettingLastMessageFromLog(){
        String message = "New message to logging";
        logger.addMessageToLog(message);
        String logMessage = logger.getLastMessage();
        System.out.println(logMessage);
    }
    public void testAddingNewMessageToLog(){
        CrazyLogger logger = new CrazyLogger();

    }
    public void testGettingMessageByDate(){
        String logMessageByDate = logger.getMessageByDate("");
    }


}