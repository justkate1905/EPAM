package t01;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;


/**
 * Created by Katerina on 07.03.2017.
 */
public class CrazyLoggerTest extends TestCase {

    CrazyLogger logger = new CrazyLogger();

    @Test
    public void testAddingAndGettingLastMessageFromLog(){
        String message = "New message to logging";
        logger.addMessageToLog(message);
        String logMessage = logger.getLastMessage();
        System.out.println(logMessage);
    }

    @Test
    public void testGettingMessageByDate(){
        List<String> logMessagesByDate = logger.getMessagesByDate("");
    }


}