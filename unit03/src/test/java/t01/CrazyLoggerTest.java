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
        assertTrue("Message was added. Returning of the right message is : ",logMessage.contains("New message to logging"));
    }

    @Test
    public void testGettingMessageByDate(){
        final String message = "Message for test";
        logger.addMessageToLog(message);

        List<String> logMessagesByDate = logger.getMessagesByDate("09-03-2017");
        assertFalse(logMessagesByDate.isEmpty());

        String lastElement =logMessagesByDate.get(logMessagesByDate.size()-1);
        assertTrue(lastElement.contains(message));

    }
    @Test
    public void testGettingMessageByNotExistingDate(){
        List<String> logMessagesByDate = logger.getMessagesByDate("04-03-2017");
        assertTrue(logMessagesByDate.isEmpty());
    }


}