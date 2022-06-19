import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class getDate {
    public static String main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy", Locale.ENGLISH);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);

    }


}
