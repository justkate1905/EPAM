package t01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Katerina on 06.03.2017.
 */
@SuppressWarnings("ALL")
public class CrazyLogger {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy : HH-mm");

    StringBuilder log = new StringBuilder();
    int indexOfLastMessageBeginning = 0;
    public String getLastMessage() {
        String message = log.substring(indexOfLastMessageBeginning);
        return message;
    }

    public void addMessageToLog(String message) {
        indexOfLastMessageBeginning = log.lastIndexOf(";")+1;
        LocalDateTime current = LocalDateTime.now();
        log.append(formatter.format(current))
                .append(" - ")
                .append(message)
                .append(";");
    }

    public String getMessageByDate(String date) {
        
    }
}
