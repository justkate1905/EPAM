package t01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
                .append(";\n");
    }

    public List<String> getMessagesByDate(String date) {
        List<String> messages = new ArrayList<String>();
        int lastIndex = log.lastIndexOf(date,0);
        while(lastIndex!=-1){
            messages.add(log.substring(lastIndex,log.indexOf(";\n",lastIndex)));
        }
        return messages;
    }
}
