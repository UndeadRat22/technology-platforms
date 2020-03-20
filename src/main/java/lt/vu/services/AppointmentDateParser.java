package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class AppointmentDateParser {
    private static String BASE_PATTERN = "yyyy-MM-dd HH:mm";
    public LocalDateTime parse(String time){
        LocalDateTime date = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(BASE_PATTERN);
            date = LocalDateTime.parse(time, formatter);
        } catch (Exception e){

        }
        return date;
    }
}
